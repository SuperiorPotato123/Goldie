package goldieLocks.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.InheritancePower;
import goldieLocks.powers.InvestedInterestPower;
import goldieLocks.util.CardStats;

public class InvestedInterest extends BaseCard {

    public static final String ID = makeID(InvestedInterest.class.getSimpleName());

    private static final int DAMAGE = 10;
    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 2;




    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );

    public InvestedInterest() {
        super(ID, info);

        setDamage(DAMAGE);
        setMagic(MAGIC, UPG_MAGIC);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new ApplyPowerAction(m, p, new InvestedInterestPower(m, magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new InvestedInterest();
    }
}

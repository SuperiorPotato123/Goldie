package goldieLocks.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class MakeGodBleed extends BaseCard {

    public static final String ID = makeID(MakeGodBleed.class.getSimpleName());

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 2;



    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            2
    );

    public MakeGodBleed() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
        this.baseMagicNumber = 1;
        this.magicNumber = this.baseMagicNumber;
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(1);
            upgradeDamage(UPG_DAMAGE);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        m.addPower(new VulnerablePower(m, 1, false));
        calculateCardDamage(m);
        //addToTop(new ApplyPowerAction(m, p, new VulnerablePower(m, 1, false), 1));
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new MakeGodBleed();
    }
}

package goldieLocks.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class IronFist extends BaseCard {

    public static final String ID = makeID(IronFist.class.getSimpleName());

    private static final int MAGIC = 8;
    private static final int DAMAGE = 15;
    private static final int UPG_DAMAGE = 5;

    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            0
    );

    public IronFist() {
        super(ID, info);

        setMagic(MAGIC);
        setDamage(DAMAGE, UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.gold >= 8) {
            p.loseGold(8);
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new IronFist();
    }
}

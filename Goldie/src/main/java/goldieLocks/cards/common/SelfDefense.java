package goldieLocks.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class SelfDefense extends BaseCard {

    public static final String ID = makeID(SelfDefense.class.getSimpleName());

    private static final int DAMAGE = 4;


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    public SelfDefense() {
        super(ID, info);

        setDamage(DAMAGE);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();

            upgradeMagicNumber(1);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        addToBot(new DrawCardAction(p, baseMagicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SelfDefense();
    }
}

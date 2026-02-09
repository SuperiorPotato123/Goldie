package goldieLocks.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.unique.LimitBreakAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.LithiumIonPower;
import goldieLocks.powers.OverloadPower;
import goldieLocks.util.CardStats;

public class Overload extends BaseCard {

    public static final String ID = makeID(Overload.class.getSimpleName());


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            2
    );

    public Overload() {
        super(ID, info);

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBaseCost(0);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new OverloadPower(p, 1)));
        addToBot(new LimitBreakAction());
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Overload();
    }
}

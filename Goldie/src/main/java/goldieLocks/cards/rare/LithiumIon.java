package goldieLocks.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.BloodMoneyPower;
import goldieLocks.powers.LithiumIonPower;
import goldieLocks.util.CardStats;

public class LithiumIon extends BaseCard {

    public static final String ID = makeID(LithiumIon.class.getSimpleName());


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );

    public LithiumIon() {
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
        addToBot(new ApplyPowerAction(p, p, new LithiumIonPower(p, 1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new LithiumIon();
    }
}

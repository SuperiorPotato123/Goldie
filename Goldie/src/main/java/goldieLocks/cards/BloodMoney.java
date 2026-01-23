package goldieLocks.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.bloodMoneyPower;
import goldieLocks.util.CardStats;

public class BloodMoney extends BaseCard{

    public static final String ID = makeID(BloodMoney.class.getSimpleName());


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            3
    );

    public BloodMoney() {
        super(ID, info);

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeBaseCost(2);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new bloodMoneyPower(p, 1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new BloodMoney();
    }
}

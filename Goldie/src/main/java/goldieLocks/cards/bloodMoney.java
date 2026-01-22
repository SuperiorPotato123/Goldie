package goldieLocks.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.bloodMoneyPower;
import goldieLocks.util.CardStats;

public class bloodMoney extends BaseCard{

    public static final String ID = makeID(bloodMoney.class.getSimpleName());


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );

    public bloodMoney() {
        super(ID, info);

    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new bloodMoneyPower(p, 1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new bloodMoney();
    }
}

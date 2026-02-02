package goldieLocks.cards.common;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class Customize extends BaseCard {

    public static final String ID = makeID(Customize.class.getSimpleName());

    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

    public Customize() {
        super(ID, info);

        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;

        setCustomVar("magic2", VariableType.MAGIC, 1, 1);
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(2);
            upgradeCustomVar("magic2");
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, customVar("magic2"))));
        p.loseGold(magicNumber);
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Customize();
    }
}

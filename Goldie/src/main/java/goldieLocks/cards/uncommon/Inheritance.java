package goldieLocks.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.InheritancePower;
import goldieLocks.util.CardStats;

public class Inheritance extends BaseCard {

    public static final String ID = makeID(Inheritance.class.getSimpleName());



    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            2
    );

    public Inheritance() {
        super(ID, info);

        this.baseMagicNumber = 1;
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
        addToBot(new ApplyPowerAction(p, p, new InheritancePower(p, magicNumber)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Inheritance();
    }
}

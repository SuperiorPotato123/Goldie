package goldieLocks.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class charisma extends BaseCard{

    public static final String ID = makeID(charisma.class.getSimpleName());

    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.ENEMY,
            1
    );

    public charisma() {
        super(ID, info);

        this.baseMagicNumber = 5;
        this.magicNumber = this.baseMagicNumber;
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(2);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(m !=null && m.intent != AbstractMonster.Intent.ATTACK && m.intent != AbstractMonster.Intent.ATTACK_BUFF && m.intent != AbstractMonster.Intent.ATTACK_DEBUFF
        && m.intent != AbstractMonster.Intent.ATTACK_DEFEND) {
            addToBot(new GainGoldAction(magicNumber));
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new charisma();
    }
}

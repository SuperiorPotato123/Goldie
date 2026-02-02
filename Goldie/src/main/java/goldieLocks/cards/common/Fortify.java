package goldieLocks.cards.common;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class Fortify extends BaseCard {

    public static final String ID = makeID(Fortify.class.getSimpleName());

    private static final int BLOCK = 15;
    private static final int UPG_BLOCK = 5;


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            2
    );

    public Fortify() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));
        addToBot(new DrawCardAction(p, baseMagicNumber));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Fortify();
    }
}

package goldieLocks.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.InvisiblePower;
import goldieLocks.util.CardStats;

public class Invisible extends BaseCard {

    public static final String ID = makeID(Invisible.class.getSimpleName());

    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 2;


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

    public Invisible() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
        this.baseMagicNumber = 4;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));
        addToBot(new ApplyPowerAction(p, p, new InvisiblePower(p, 1)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Invisible();
    }
}

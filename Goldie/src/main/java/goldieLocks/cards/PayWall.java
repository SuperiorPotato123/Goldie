package goldieLocks.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.character.GainGoldActionExtra;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class PayWall extends BaseCard{

    public static final String ID = makeID(PayWall.class.getSimpleName());

    private static final int BLOCK = 10;
    private static final int UPG_BLOCK = 5;


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

    public PayWall() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));
        p.loseGold(4);
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new PayWall();
    }
}

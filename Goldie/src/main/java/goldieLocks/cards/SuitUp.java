package goldieLocks.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class SuitUp extends BaseCard{

    public static final String ID = makeID(SuitUp.class.getSimpleName());

    private static final int BLOCK = 7;
    private static final int UPG_BLOCK = 3;


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.NONE,
            -2
    );

    public SuitUp() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
    }

    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        this.cantUseMessage = cardStrings.EXTENDED_DESCRIPTION[0];
        return false;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
    }

    @Override
    public void triggerOnEndOfPlayerTurn() {
        // Surplus effect
        if(EnergyPanel.totalCount > 0) {
            AbstractPlayer p = AbstractDungeon.player;
            addToBot(new GainBlockAction(p, p, this.block));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SuitUp();
    }
}

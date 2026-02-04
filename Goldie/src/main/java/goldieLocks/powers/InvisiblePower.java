package goldieLocks.powers;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import goldieLocks.character.GainGoldActionExtra;

import static goldieLocks.BasicMod.makeID;

public class InvisiblePower extends BasePower {
    public static final String POWER_ID = makeID(InvisiblePower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    private static int blockToKeep;
    private static boolean attackedThisTurn;

    public InvisiblePower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
        attackedThisTurn = false;
    }


    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        attackedThisTurn = true;
        return super.onAttacked(info, damageAmount);
    }

    @Override
    public void atEndOfRound() {
        if (attackedThisTurn) {
            attackedThisTurn = false;
            blockToKeep = 0;
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));

        } else {
            blockToKeep = AbstractDungeon.player.currentBlock;
        }
    }

    @Override
    public void atStartOfTurn() {
        {addToBot(new GainBlockAction(owner, blockToKeep));}
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}

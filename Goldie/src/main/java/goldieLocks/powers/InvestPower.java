package goldieLocks.powers;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import goldieLocks.character.GainGoldActionExtra;

import static goldieLocks.BasicMod.makeID;

public class InvestPower extends BasePower {
    public static final String POWER_ID = makeID(InvestPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    // Idea for this:
    // Evertime the power is played again, the gold count goes up.
    // However, you have to wait to get all of the gold for the extended period of time
    // Example:
    // Play it once (counter is at 10, gold count is at 200)
    // On turn 3 you play it again (counter becomes 17, gold count is at 400)
    // Now you have to wait 17 turns to get 400 gold

    private static int GoldCount = 0;


    public InvestPower(AbstractCreature owner, int amount)
    {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
        GoldCount += 200;
        updateDescription();
    }

    public void atEndOfRound() {
        if (this.amount == 0) {
            // This just mimics how other cards are written. This shouldn't get called most of the time if ever
            addToBot(new GainGoldActionExtra(GoldCount, this.owner));
            addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
            GoldCount = 0;
        } else if (this.amount == 1){
            addToBot(new GainGoldActionExtra(GoldCount, this.owner));
            addToBot(new ReducePowerAction(this.owner, this.owner, POWER_ID, 1));
            GoldCount = 0;
            updateDescription();
        } else {
            addToBot(new ReducePowerAction(this.owner, this.owner, POWER_ID, 1));
            updateDescription();
        }
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1] + GoldCount + DESCRIPTIONS[2];
    }
}

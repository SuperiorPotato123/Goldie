package goldieLocks.powers;

import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static goldieLocks.BasicMod.makeID;

public class InheritancePower extends BasePower {
    public static final String POWER_ID = makeID(InheritancePower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;


    public InheritancePower(AbstractCreature owner, int amount)
    {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);

    }

    public void atStartOfTurn() {
        addToBot(new GainGoldAction(amount));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }
}

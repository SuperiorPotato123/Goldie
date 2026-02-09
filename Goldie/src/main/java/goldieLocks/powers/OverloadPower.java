package goldieLocks.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.EntanglePower;

import static goldieLocks.BasicMod.makeID;

public class OverloadPower extends BasePower {
    public static final String POWER_ID = makeID(OverloadPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;


    public OverloadPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    @Override
    public void atStartOfTurn() {
        addToBot(new ApplyPowerAction(this.owner, this.owner, new EntanglePower(this.owner), 1));
        addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
        super.atStartOfTurn();
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}

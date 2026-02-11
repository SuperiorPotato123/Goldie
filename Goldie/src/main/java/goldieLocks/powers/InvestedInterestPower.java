package goldieLocks.powers;

import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static goldieLocks.BasicMod.makeID;

public class InvestedInterestPower extends BasePower {
    public static final String POWER_ID = makeID(InvestedInterestPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;

    public InvestedInterestPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void onGoldGain() {
        flash();
        addToBot(new LoseHPAction(this.owner, null, this.amount));
    }

    @Override
    public void atStartOfTurn() {
        addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}

package goldieLocks.powers;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import goldieLocks.character.GainGoldActionExtra;

import static goldieLocks.BasicMod.makeID;

public class BloodMoneyPower extends BasePower {
    public static final String POWER_ID = makeID(BloodMoneyPower.class.getSimpleName());
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;


    public BloodMoneyPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void wasHPLost(DamageInfo info, int damageAmount) {
        addToBot(new GainGoldActionExtra(damageAmount, this.owner));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}

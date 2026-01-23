package goldieLocks.powers;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import goldieLocks.character.GainGoldActionExtra;

import static goldieLocks.BasicMod.makeID;

public class inheritencePower extends BasePower {
    public static final String POWER_ID = makeID(inheritencePower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;


    public inheritencePower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void atStartOfTurn() {
        addToBot(new GainGoldActionExtra(1, this.owner));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}

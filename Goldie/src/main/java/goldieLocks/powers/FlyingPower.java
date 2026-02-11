package goldieLocks.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static goldieLocks.BasicMod.makeID;

public class FlyingPower extends BasePower {
    public static final String POWER_ID = makeID(FlyingPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    private static boolean attackedThisTurn;

    public FlyingPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    @Override
    public float atDamageReceive(float damage, DamageInfo.DamageType damageType) {
        if (damageType != DamageInfo.DamageType.HP_LOSS) {
            return damage*.5f;
        }
        return damage;
    }

    @Override
    public void atStartOfTurn() {
        addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}

package goldieLocks.powers;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.BasicMod;

import static goldieLocks.BasicMod.makeID;

public class InvisiblePower extends BasePower {
    public static final String POWER_ID = makeID(InvisiblePower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_BASED = false;
    private static boolean attackedThisTurn;

    public InvisiblePower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
        return super.onAttacked(info, damageAmount);

    }


    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}

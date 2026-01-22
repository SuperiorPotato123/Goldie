package goldieLocks.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

import static goldieLocks.BasicMod.makeID;

public class bloodMoneyPower extends BasePower {
    public static final String POWER_ID = makeID(bloodMoneyPower.class.getSimpleName());
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_BASED = false;


    public bloodMoneyPower(AbstractCreature owner, int amount) {
        super(POWER_ID, TYPE, TURN_BASED, owner, amount);
    }

    public void wasHPLost(DamageInfo info, int damageAmount) {
        this.owner.gainGold(damageAmount);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }
}

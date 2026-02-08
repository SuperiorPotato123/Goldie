package goldieLocks.Patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.evacipated.cardcrawl.modthespire.lib.SpireReturn;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import goldieLocks.BasicMod;
import goldieLocks.powers.InvisiblePower;

public class InvisiblePowerPatch {

    @SpirePatch2(clz = AbstractCreature.class, method = "hasPower")
    public static class LithiumIonPatch {
        private static SpireReturn<Boolean> Prefix(AbstractCreature __instance, String targetID) {
            if(targetID == "Blur") {
                    for (AbstractPower p : __instance.powers) {
                        if (p.ID.equals(InvisiblePower.POWER_ID)) {
                            return SpireReturn.Return(true);
                        }
                    }
            }
            return SpireReturn.Continue();
        }
    }
}

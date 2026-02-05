package goldieLocks.Patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import goldieLocks.powers.LithiumIonPower;

public class EnergyManagerPatches {

    @SpirePatch2(clz = EnergyManager.class, method = "recharge")
    public static class Recharge
    {

        public static void Replace(EnergyManager __instance) {
            if (AbstractDungeon.player.hasRelic("Ice Cream")) {
                if (EnergyPanel.totalCount > 0) {
                    AbstractDungeon.player.getRelic("Ice Cream").flash();
                    AbstractDungeon.actionManager.addToTop((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, AbstractDungeon.player
                            .getRelic("Ice Cream")));
                }
                EnergyPanel.addEnergy(__instance.energy);
            } else if (AbstractDungeon.player.hasPower("Conserve")) {
                if (EnergyPanel.totalCount > 0)
                    AbstractDungeon.actionManager.addToTop((AbstractGameAction)new ReducePowerAction((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player, "Conserve", 1));
                EnergyPanel.addEnergy(__instance.energy);
            } else if (AbstractDungeon.player.hasPower(LithiumIonPower.POWER_ID)) {
                EnergyPanel.addEnergy(__instance.energy);
            } else {
                EnergyPanel.setEnergy(__instance.energy);
            }
            AbstractDungeon.actionManager.updateEnergyGain(__instance.energy);
        }
    }
}

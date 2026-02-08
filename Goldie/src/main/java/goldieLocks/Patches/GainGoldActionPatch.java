package goldieLocks.Patches;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch2;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;
import goldieLocks.BasicMod;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.LithiumIonPower;

public class GainGoldActionPatch {

    @SpirePatch2(clz = GainGoldAction.class, method = SpirePatch.CONSTRUCTOR)
    public static class GoldPatch {
        public static void Prefix(int amount) {
            MyCharacter.GOLD_GAINED_THIS_COMBAT += amount;
        }

            public static void Postfix(int amount) {
                for (int i = 0; i < amount; i++)
                    AbstractDungeon.effectList.add(new GainPennyEffect(100f, 100f));
            }
        }
    }

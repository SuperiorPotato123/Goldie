package goldieLocks.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class Maneuver extends BaseCard {

    public static final String ID = makeID(Maneuver.class.getSimpleName());

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;

    private static final int BLOCK = 5;
    private static final int UPG_BLOCK = 3;



    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    public Maneuver() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
        setBlock(BLOCK, UPG_BLOCK);
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

    @Override
    public void triggerOnEndOfPlayerTurn() {
        // Surplus effect
        if(EnergyPanel.totalCount > 0) {
            addToBot(new GainBlockAction(AbstractDungeon.player, block));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Maneuver();
    }
}

package goldieLocks.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class SpareCannon extends BaseCard{

    public static final String ID = makeID(SpareCannon.class.getSimpleName());

    private static final int DAMAGE = 9;
    private static final int UPG_DAMAGE = 3;



    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    public SpareCannon() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(1);
            upgradeDamage(2);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
    }

    @Override
    public void triggerOnEndOfPlayerTurn() {
        // Surplus effect
        if(EnergyPanel.totalCount > 0) {
            AbstractDungeon.player.hand.moveToDeck(this, false);
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SpareCannon();
    }
}

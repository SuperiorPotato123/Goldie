package goldieLocks.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class EnergyBeam extends BaseCard {

    public static final String ID = makeID(EnergyBeam.class.getSimpleName());

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 2;



    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    public EnergyBeam() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);

        setCustomVar("damage2", VariableType.DAMAGE, 3, 1);
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();

            upgradeDamage(2);
            upgradeCustomVar("damage2");
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
            AbstractMonster randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
            calculateCardDamage(randomMonster);
            if(randomMonster != null) addToBot(new DamageAction(randomMonster, new DamageInfo(AbstractDungeon.player, customVar("damage2"), this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));

            randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
            calculateCardDamage(randomMonster);
            if(randomMonster != null) addToBot(new DamageAction(randomMonster, new DamageInfo(AbstractDungeon.player, customVar("damage2"), this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new EnergyBeam();
    }
}

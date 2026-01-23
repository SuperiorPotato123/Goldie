package goldieLocks.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class EnergyBeam extends BaseCard{

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
        this.baseMagicNumber = 3;
        this.magicNumber = this.baseMagicNumber;
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
        if(AbstractDungeon.player.energy.energy > 0) {
            AbstractMonster randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
            if(randomMonster != null) addToBot(new DamageAction(randomMonster, new DamageInfo(AbstractDungeon.player, magicNumber, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));

            randomMonster = AbstractDungeon.getMonsters().getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
            if(randomMonster != null) addToBot(new DamageAction(randomMonster, new DamageInfo(AbstractDungeon.player, magicNumber, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new EnergyBeam();
    }
}

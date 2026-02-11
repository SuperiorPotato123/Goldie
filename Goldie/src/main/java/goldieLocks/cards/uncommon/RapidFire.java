package goldieLocks.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.InvestedInterestPower;
import goldieLocks.util.CardStats;

public class RapidFire extends BaseCard {

    public static final String ID = makeID(RapidFire.class.getSimpleName());

    private static final int DAMAGE = 1;
    private static final int MAGIC = 6;

    private static CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.UNCOMMON,
            CardTarget.NONE,
            1
    );


    public RapidFire() {
        super(ID, info);

        setDamage(DAMAGE);
        setMagic(MAGIC);
    }

    public void upgrade() {
        if(!upgraded) {
            upgradeName();
            this.target = CardTarget.ENEMY;
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        if (this.upgraded) {
            for (int i = 0; i < magicNumber; i++) {
                addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
            }
        } else {
            for (int i = 0; i < magicNumber; i++) {
                addToBot(new AttackDamageRandomEnemyAction(this, AbstractGameAction.AttackEffect.SLASH_VERTICAL));
            }
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new RapidFire();
    }
}

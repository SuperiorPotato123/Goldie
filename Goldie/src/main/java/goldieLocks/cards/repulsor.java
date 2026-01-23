package goldieLocks.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class repulsor extends BaseCard{

    public static final String ID = makeID(repulsor.class.getSimpleName());

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 2;



    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.ENEMY,
            0
    );

    public repulsor() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(2);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.gold > 1){
            p.loseGold(2);
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new repulsor();
    }
}

package goldieLocks.cards.common;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.util.CardStats;

public class Missile extends BaseCard {

    public static final String ID = makeID(Missile.class.getSimpleName());

    private static final int DAMAGE = 15;
    private static final int UPG_DAMAGE = 5;


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            0
    );

    public Missile() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
        this.baseMagicNumber = 5;
        this.magicNumber = this.baseMagicNumber;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.gold >= magicNumber){
            addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL)));
            p.loseGold(magicNumber);
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Missile();
    }
}

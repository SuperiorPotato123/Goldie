package goldieLocks.cards.rare;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.character.ObliterateAction;
import goldieLocks.util.CardStats;

public class Obliterate extends BaseCard {

    public static final String ID = makeID(Obliterate.class.getSimpleName());

    private static final int DAMAGE = 15;
    private static final int UPG_DAMAGE = 5;



    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.ATTACK,
            CardRarity.RARE,
            CardTarget.ENEMY,
            2
    );

    public Obliterate() {
        super(ID, info);

        setDamage(DAMAGE, UPG_DAMAGE);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
            if(m != null) {
                addToBot(new ObliterateAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL)));
            }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Obliterate();
    }
}

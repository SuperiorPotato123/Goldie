package goldieLocks.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.InvisiblePower;
import goldieLocks.util.CardStats;

public class Invisible extends BaseCard {

    public static final String ID = makeID(Invisible.class.getSimpleName());

    private static final int BLOCK = 6;
    private static final int UPG_BLOCK = 4;


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.RARE,
            CardTarget.SELF,
            1
    );

    public Invisible() {
        super(ID, info);

        setBlock(BLOCK, UPG_BLOCK);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new GainBlockAction(p, p, this.block));

        for (AbstractMonster mm : AbstractDungeon.getMonsters().monsters) {
            if(mm !=null && mm.intent != AbstractMonster.Intent.ATTACK && mm.intent != AbstractMonster.Intent.ATTACK_BUFF && mm.intent != AbstractMonster.Intent.ATTACK_DEBUFF) {
                addToTop(new ApplyPowerAction(p, p, new InvisiblePower(p, 1)));
                break;
            }
        }

    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Invisible();
    }
}

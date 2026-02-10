package goldieLocks.cards.rare;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import goldieLocks.cards.BaseCard;
import goldieLocks.character.MyCharacter;
import goldieLocks.powers.InvestPower;
import goldieLocks.util.CardStats;

public class Infrastructure extends BaseCard {

    public static final String ID = makeID(Infrastructure.class.getSimpleName());


    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.POWER,
            CardRarity.RARE,
            CardTarget.SELF,
            0
    );

    public Infrastructure() {
        super(ID, info);

        setCustomVar("goldCost", 15);
        setCustomVar("energyGain", 1, 1);
        setCustomVar("cardDraw", 2, 2);

    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if(p.gold >= customVar("goldCost")) {
            p.loseGold(customVar("goldCost"));
            addToBot(new GainEnergyAction(customVar("energyGain")));
            addToBot(new DrawCardAction(p, customVar("cardDraw")));
        }
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new Infrastructure();
    }
}

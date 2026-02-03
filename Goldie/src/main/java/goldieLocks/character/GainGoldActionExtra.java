package goldieLocks.character;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class GainGoldActionExtra extends AbstractGameAction{

    private int amount;
    private AbstractCreature owner;

    public GainGoldActionExtra(int amount, AbstractCreature p) {
        this.amount = amount;
        this.owner = p;
    }

    public void update() {
        owner.gainGold(this.amount);
        CardCrawlGame.sound.play("GOLD_JINGLE");
        MyCharacter.GOLD_GAINED_THIS_COMBAT += this.amount;
        this.isDone = true;
    }
}


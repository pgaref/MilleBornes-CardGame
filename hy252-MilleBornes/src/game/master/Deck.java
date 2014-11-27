/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.master;

import game.CardCollection.CardPile;
import game.CardCollection.DiscardPile;
import game.CardCollection.DrawPile;
import game.CardCollection.NotSupportedOperationException;
import game.Cards.Card;
import game.Cards.Distance;

/**
 *
 * @author pg1712
 */
public class Deck {
    
    private CardPile drawCards;
    private CardPile discardCards;

    
    public Deck(){
        this.discardCards = new DiscardPile();
        this.drawCards = new DrawPile();
        
        for(int i = 0 ; i < 50; i++){
                Card tmp = new Distance(75);
                try{
                    this.drawCards.addCard(tmp);
                    
                }catch(NotSupportedOperationException ex){
                    
                    ex.printStackTrace();
                }
        }
        
    }
    
    public void initializeAll(){
        this.discardCards = null;
        this.drawCards = null;
        new Deck();
    }
    /**
     * @return the drawCards
     */
    public CardPile getDrawCards() {
        return drawCards;
    }

    /**
     * @param drawCards the drawCards to set
     */
    public void setDrawCards(CardPile drawCards) {
        this.drawCards = drawCards;
    }

    /**
     * @return the discardCards
     */
    public CardPile getDiscardCards() {
        return discardCards;
    }

    /**
     * @param discardCards the discardCards to set
     */
    public void setDiscardCards(CardPile discardCards) {
        this.discardCards = discardCards;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CardCollection;

import game.Cards.Card;
import game.Cards.Type.CardType;

/**
 *
 * @author Author
 */
public class DiscardPile extends CardPile{
    
    
    public DiscardPile(){
        super();
        this.type=CardType.DISCARD;
    }
    
    
    
    public void addCard(Card tmp){
        cards.add(tmp);
    }
    
    
    public Card removeCard(Card c){
        for(int i =0 ; i < cards.size(); i++){
            if(cards.get(i).equals(c))
                return cards.remove(i);
        }
        System.out.println("Card: "+ c +" was not found!  ");
        return null;
    }
}

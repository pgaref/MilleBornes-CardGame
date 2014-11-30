/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CardCollection;

import game.Cards.Card;
import game.Cards.Type.CardType;
import java.util.ArrayList;

/**
 *
 * @author Author
 */
public class DistancePile extends CardPile{
    
    
    
    public DistancePile(){
        super();
        this.type=CardType.DISTANCE;
    }
    
    public DistancePile(ArrayList<Card> list){
        super();
        this.type=CardType.DISTANCE;
        this.cards.addAll(list);
    }
    
    public void addCard(Card tmp) throws NotSupportedOperationException{
        throw new NotSupportedOperationException("Cannnot add Card "+tmp);
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

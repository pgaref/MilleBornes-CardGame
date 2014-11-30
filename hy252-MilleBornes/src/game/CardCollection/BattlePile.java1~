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
public class BattlePile extends CardPile{
    
    public BattlePile(){
        super();
        this.type =CardType.BATTLE;
    }
    
    public BattlePile(ArrayList<Card> a){
        super();
        this.type =CardType.BATTLE;
        this.cards.addAll(a);
        
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

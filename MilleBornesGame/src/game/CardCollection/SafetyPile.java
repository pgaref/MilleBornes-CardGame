/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CardCollection;

import game.Cards.Card;
import game.Cards.Safety;
import game.Cards.Type.CardType;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class SafetyPile.
 *
 * @author Author
 */
public class SafetyPile extends AbstractPile{
    
	/**
	 * The constructor for building a new instance of a SafetyPile
	 * No parameters! Therefore, no specific type and actually no cards
	 * inside!.
	 */
	
    public SafetyPile(){
        this.cards = new ArrayList<Card>();
        this.type=CardType.SAFETY;
    }
    
    /**
     * The constructor for building a new instance of a CardPile
     * with given cards and actually no specific type!! .
     *
     * @param list the list
     */
    public SafetyPile(ArrayList<Card> list){
        super();
        this.type=CardType.SAFETY;
        this.cards.addAll(list);
    }
    
    /**
     * Adds the card.
     *
     * @param tmp the tmp
     * @throws NotSupportedOperationException the not supported operation exception
     * @see game.CardCollection.AbstractPile#addCard(game.Cards.Card)
     */
    public void addCard(Card tmp) throws NotSupportedOperationException{
    	if(!(tmp instanceof Safety))
    		throw new NotSupportedOperationException("Cannnot add Card "+tmp);
    	else
    		this.cards.add(tmp);
    }
    
    
}

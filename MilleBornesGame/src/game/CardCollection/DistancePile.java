/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CardCollection;

import game.Cards.Card;
import game.Cards.Distance;
import game.Cards.Type.CardType;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DistancePile.
 *
 * @author Author
 */
public class DistancePile extends AbstractPile{
    
    
	/**
	 * The constructor for building a new instance of a DistancePile
	 * No parameters! Therefore, no specific type and actually no cards
	 * inside!.
	 */
    public DistancePile(){
    	this.cards = new ArrayList<Card>();
        this.type=CardType.DISTANCE;
    }
    
    /**
     * The constructor for building a new instance of a CardPile
     * with given cards and actually no specific type!! .
     *
     * @param list the list
     */
    public DistancePile(ArrayList<Card> list){
        this.type=CardType.DISTANCE;
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
    	if(!(tmp instanceof Distance))
    		throw new NotSupportedOperationException("Cannnot add Card "+tmp);
    	else
    		this.cards.add(tmp);
    }
    
}

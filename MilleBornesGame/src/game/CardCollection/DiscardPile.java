/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CardCollection;

import game.Cards.Card;
import game.Cards.Type.CardType;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DiscardPile.
 *
 * @author Author
 */
public class DiscardPile extends AbstractPile{
    
	
	/**
	 * The constructor for building a new instance of a DistancePile
	 * No parameters! Therefore, no specific type and actually no cards
	 * inside!.
	 */
	
    public DiscardPile(){
        this.cards = new ArrayList<Card>();
        this.type=CardType.DISCARD;
    }
    
    /**
     * The constructor for building a new instance of a CardPile
     * with given cards and actually no specific type!! .
     *
     * @param a the a
     */
    public DiscardPile(ArrayList<Card> a){
    	this.cards  = new ArrayList<Card>();
        this.type = CardType.DISCARD;
        this.cards.addAll(a);
    }
    
    /**
     * Adds the card.
     *
     * @param tmp the tmp
     * @see game.CardCollection.AbstractPile#addCard(game.Cards.Card)
     */
    public void addCard(Card tmp){
        cards.add(tmp);
    }
}
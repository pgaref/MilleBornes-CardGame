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
 * The Class BattlePile.
 *
 * @author Author
 */
public class BattlePile extends AbstractPile{
    
	/**
	 * The constructor for building a new instance of a CardPile
	 * No parameters! Therefore, no specific type and actually no cards
	 * inside!.
	 */
    public BattlePile(){
        this.cards = new ArrayList<Card>();
        this.type =CardType.BATTLE;
    }
    
    /**
     * The constructor for building a new instance of a CardPile
     * with given cards and actually no specific type!! .
     *
     * @param a the a
     */
    
    public BattlePile(ArrayList<Card> a){
        this.cards  = new ArrayList<Card>();
        this.type =CardType.BATTLE;
        this.cards.addAll(a);
        
    }
    
    /**
     * Adds the card.
     *
     * @param tmp the tmp
     * @throws NotSupportedOperationException the not supported operation exception
     * @see game.CardCollection.AbstractPile#addCard(game.Cards.Card)
     */
    public void addCard(Card tmp) throws NotSupportedOperationException{
        throw new NotSupportedOperationException("Cannnot add Card "+tmp);
    }
    
}

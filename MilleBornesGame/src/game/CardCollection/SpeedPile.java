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
 * The Class SpeedPile.
 *
 * @author Author
 */
public class SpeedPile extends AbstractPile{
      
	/**
	 * The constructor for building a new instance of a SpeedPile
	 * No parameters! Therefore, no specific type and actually no cards
	 * inside!.
	 */
	
    public SpeedPile(){
        this.cards = new ArrayList<Card>();
        this.type=CardType.SPEED;
    }
    
    /**
     * The constructor for building a new instance of a CardPile
     * with given cards and actually no specific type!! .
     *
     * @param list the list
     */
    public SpeedPile(ArrayList<Card> list){
        super();
        this.type=CardType.SPEED;
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
        throw new NotSupportedOperationException("Cannnot add Card "+tmp);
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game.Cards;

/**
 * The Class EmptyCard.
 *
 * @author Author
 */
public class EmptyCard extends Card {
    
    /**
     * Instantiates a new empty card.
     */
    public EmptyCard(){
        super();
        this.setImagePath("/game/images/back.jpg");
    }

    /* (non-Javadoc)
     * @see game.Cards.Card#match(game.Cards.Card)
     */
    @Override
    public boolean match(Card other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

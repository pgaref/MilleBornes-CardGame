/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * The Class Priority.
 *
 * @author Author
 */
public class Priority extends Safety{
    
    /**
     * Instantiates a new priority.
     */
    public Priority(){
    	this.setImagePath("/game/images/"+"RIGHT_OF_WAY.jpg");
    }
    
    /* (non-Javadoc)
     * @see game.Cards.Card#match(game.Cards.Card)
     */
    @Override
    public boolean match(Card other) {
    	if( (other instanceof Stop) || (other instanceof SpeedLimit) )
     		return true;
     	return false;
    }
}

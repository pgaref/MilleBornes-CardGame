/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * The Class ExtraTank.
 *
 * @author Author
 */
public class ExtraTank extends Safety{
	
	
	/**
	 * Instantiates a new fuel tank.
	 */
	public ExtraTank(){
		this.setImagePath("/game/images/"+"EXTRA_TANK.jpg");
	}
    
    /* (non-Javadoc)
     * @see game.Cards.Card#match(game.Cards.Card)
     */
    @Override
    public boolean match(Card other) {
    	
    	if( (other instanceof OutOfGas) )
     		return true;
     	return false;
    }
    
    
}

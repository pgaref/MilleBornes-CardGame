/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Cards;

/**
 * The Class PunctureProofTire.
 *
 * @author Author
 */
public class PunctureProofTire extends Safety{
    
    /**
     * Instantiates a new puncture proof tyre.
     */
    public PunctureProofTire(){
    	this.setImagePath("/game/images/"+"PUNCTURE_PROOF.jpg");
    }
    
    /* (non-Javadoc)
     * @see game.Cards.Card#match(game.Cards.Card)
     */
    @Override
    public boolean match(Card other) {
    	if( (other instanceof FlatTire) )
     		return true;
     	return false;
    }
}

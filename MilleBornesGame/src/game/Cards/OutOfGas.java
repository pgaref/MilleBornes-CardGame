/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * The Class OutOfGas.
 *
 * @author Author
 */
public class OutOfGas extends Hazard{
    
    /**
     * Instantiates a new out of gas.
     */
    public OutOfGas(){
    	this.setImagePath("/game/images/"+"OUT_OF_GAS.jpg");
    }
    
     /* (non-Javadoc)
      * @see game.Cards.Card#match(game.Cards.Card)
      */
     @Override
    public boolean match(Card other) {
    	// if((other instanceof ExtraTank) || ( other instanceof Gas))
     	//	return true;
     	return false;
    }
}

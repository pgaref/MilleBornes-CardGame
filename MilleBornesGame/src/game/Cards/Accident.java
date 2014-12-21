/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Cards;

/**
 * The Class Accident.
 *
 * @author Author
 */
public class Accident extends Hazard{
    
    /**
     * Instantiates a new accident.
     */
    public Accident(){
    	this.setImagePath("/game/images/"+"ACCIDENT.jpg");
    }
    
    /* (non-Javadoc)
     * @see game.Cards.Card#match(game.Cards.Card)
     */
    @Override
    public boolean match(Card other) {
    	
    	//if((other instanceof Repair) || ( other instanceof DrivingAce))
    	//	return true;
    	return false;
    }
    
}

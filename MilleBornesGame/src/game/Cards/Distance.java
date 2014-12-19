/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a Distance Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class Distance extends Card{
    
    /**
     * Instantiates a new distance.
     *
     * @param value the value
     */
    public Distance(int value){
        super();
        this.setValue(value);
        this.setImagePath("/game/images/Miles_"+value+".jpg");
    }

    /* (non-Javadoc)
     * @see game.Cards.Card#match(game.Cards.Card)
     */
    @Override
    public boolean match(Card other) {
    	if( (other instanceof SpeedLimit)  && ( this.getValue() > 50))
     		return true;
     	return false;
    }
    
}

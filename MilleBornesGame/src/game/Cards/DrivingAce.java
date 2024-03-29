/**
 * 
 */
package game.Cards;

/**
 * This abstract class represents a Driving Ace Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class DrivingAce extends Safety {

	/**
	 * Instantiates a new driving ace.
	 */
	public DrivingAce() {
		this.setImagePath("/game/images/"+"DRIVING_ACE.jpg");
	}

	/* (non-Javadoc)
	 * @see game.Cards.Card#match(game.Cards.Card)
	 */
	@Override
	public boolean match(Card other) {
		if(other instanceof Accident)
    		return true;
    	return false;
	}

}

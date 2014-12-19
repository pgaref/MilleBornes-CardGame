/**
 * 
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a Stop Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class Stop extends Hazard {

	/**
	 * Instantiates a new stop.
	 */
	public Stop() {
		this.setImagePath("/game/images/"+"STOP.jpg");
	}

	/* (non-Javadoc)
	 * @see game.Cards.Card#match(game.Cards.Card)
	 */
	@Override
	public boolean match(Card other) {
		if( (other instanceof Start) )
     		return true;
     	return false;
	}

}

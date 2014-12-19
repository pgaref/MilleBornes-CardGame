/**
 * 
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a SpeedLimit Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class SpeedLimit extends Hazard {

	/**
	 * Instantiates a new speed limit.
	 */
	public SpeedLimit() {
		this.setImagePath("/game/images/"+"SPEED_LIMIT.jpg");
	}

	/* (non-Javadoc)
	 * @see game.Cards.Card#match(game.Cards.Card)
	 */
	@Override
	public boolean match(Card other) {
		// TODO Auto-generated method stub
		return false;
	}

}

/**
 * 
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a EndOfSpeedLimit Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class EndOfSpeedLimit extends Remedy {

	/**
	 * Instantiates a new out of speed limit.
	 */
	public EndOfSpeedLimit() {
		this.setImagePath("/game/images/"+"END_OF_LIMIT.jpg");
	}

	/* (non-Javadoc)
	 * @see game.Cards.Card#match(game.Cards.Card)
	 */
	@Override
	public boolean match(Card other) {
		if(other instanceof SpeedLimit)
			return true;
		return false;
	}

}

/**
 * 
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a Start Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class Start extends Remedy {

	/**
	 * Instantiates a new start.
	 */
	public Start() {
		this.setImagePath("/game/images/"+"ROLL.jpg");
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

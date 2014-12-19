/**
 * 
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a Repair Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class Repair extends Remedy {

	/**
	 * Instantiates a new repair.
	 */
	public Repair() {
		this.setImagePath("/game/images/"+"REPAIR.jpg");
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

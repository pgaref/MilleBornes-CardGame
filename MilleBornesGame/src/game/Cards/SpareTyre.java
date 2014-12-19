/**
 * 
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a SpareTyre Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class SpareTyre extends Remedy {

	/**
	 * Instantiates a new spare tyre.
	 */
	public SpareTyre() {
		this.setImagePath("/game/images/"+"SPARE_TIRE.jpg");
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

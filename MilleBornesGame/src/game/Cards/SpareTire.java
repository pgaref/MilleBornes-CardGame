/**
 * 
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a SpareTire Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class SpareTire extends Remedy {

	/**
	 * Instantiates a new spare tyre.
	 */
	public SpareTire() {
		this.setImagePath("/game/images/"+"SPARE_TIRE.jpg");
	}

	/* (non-Javadoc)
	 * @see game.Cards.Card#match(game.Cards.Card)
	 */
	@Override
	public boolean match(Card other) {
		if( (other instanceof FlatTire) )
     		return true;
     	return false;
	}

}

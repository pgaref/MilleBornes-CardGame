/**
 * 
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a Gas Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class Gas extends Remedy {

	/**
	 * Instantiates a new gas.
	 */
	public Gas() {
		this.setImagePath("/game/images/"+"GASOLINE.jpg");
	}

	/* (non-Javadoc)
	 * @see game.Cards.Card#match(game.Cards.Card)
	 */
	@Override
	public boolean match(Card other) {
		if( (other instanceof OutOfGas) )
     		return true;
     	return false;
	}

}

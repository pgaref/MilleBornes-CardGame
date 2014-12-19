/**
 * 
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a FlatTire Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public class FlatTire extends Hazard {

	/**
	 * Instantiates a new tyre.
	 */
	public FlatTire() {
		this.setImagePath("/game/images/"+"FLAT_TIRE.jpg");	}
	
	 /* (non-Javadoc)
 	 * @see game.Cards.Card#match(game.Cards.Card)
 	 */
 	@Override
	    public boolean match(Card other) {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardCollection;

import game.Cards.Card;
import java.util.ArrayList;

/**
 * This card represent a collection of cards. Extensions of this
 * class could be card collection with special characteristics.
 * For example, a card collection of only one card could be Monofylia
 * and therefore it is compatible with rounds playing Monophylia.
 * To this end, this class contain a method named getType which descibe
 * the compatible type. Plz note that there is no transformer to the "type"
 * attribute. (Children override the accessor by returning type appropriately)
 * @author Author
 */
public class CardCollection 
{
    private ArrayList<Card> cards;
    private PileType type;

    /**
     * The constructor for building a new instance of a CardCollection
     * No parameters! Therefore, no specific type and actually no cards
     * inside!
     */
    public CardCollection()
    {
        cards = new ArrayList<Card>();
        type = PileType.UNGATEGORIZED;
    }

    /**
     * The constructor for building a new instance of a CardCollection
     * with given cards and actually no specific type!! (e.g. mpazes, xeria 
     * and dropped cards could be a case)
     * @param cards the given cards to create a new CardCollection
     */
    public CardCollection(ArrayList<Card> cards)
    {
        this();
        this.cards = cards;
    }

     /**
     * @param type the type to set
     */
    public void setType(PileType type) {
        this.type = type;
    }
    
    /**
     * The round type to be returned! (Accessor)
     * See PileType enumeration for further details
     * @return the round type
     */
    public PileType getType() {
        return type;
    }

    /**
     * Returns the arraylist of the cards belonging to this card collection
     * @return a arraylist of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Sets cards of the card collection (Transformer)
     * Postcondition: getCards() == cards
     * @param cards A arraylist of cards
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * To be overidden. By default it returns false.
     * Calculates if this card collection is greater than the given one (parameter)
     * @param cCol
     * @return true if this card collection  has more power than parameter. Otherwise false.
     * @throws IncompatibleException Throws a special type of exception in case that parameter's type differs from this one
     * and therefore comparison has no meaning...
     */
    public boolean IsGreaterThan(CardCollection cCol) throws IncompatiblePileException
    {
        return false;
    }

   
    
}

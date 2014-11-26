/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CardCollection;

import game.Cards.Type.CardType;
import game.Cards.Card;
import java.util.ArrayList;

/**
 * This card represent a collection of cards. Extensions of this
 * class could be card collection with special characteristics.
 * To this end, this class contain a method named getType which describe
 * the compatible type. Plz note that there is no transformer to the "type"
 * attribute. (Children override the accessor by returning type appropriately)
 * @author Author
 */
public class CardCollection 
{
    private ArrayList<Card> cards;
    private CardType type;

    /**
     * The constructor for building a new instance of a CardCollection
     * No parameters! Therefore, no specific type and actually no cards
     * inside!
     */
    public CardCollection( )
    {
        cards = new ArrayList<Card>();
        type = CardType.UNGATEGORIZED;
    }
    
    /**
     * The constructor for building a new instance of a CardCollection
     * No parameters! Therefore, no specific type and actually no cards
     * inside!
     */
    public CardCollection(int size)
    {
        cards = new ArrayList<Card>(size);
        type = CardType.UNGATEGORIZED;
    }
    
    /**
     * The constructor for building a new instance of a CardCollection
     * No parameters! Therefore, no specific type and actually no cards
     * inside!
     */
    public CardCollection(CardType t, int size)
    {
        cards = new ArrayList<Card>(size);
        type = t;
    }
    
    /**
     * The constructor for building a new instance of a CardCollection
     * No parameters! Therefore, no specific type and actually no cards
     * inside!
     */
    public CardCollection(CardType t)
    {
        cards = new ArrayList<Card>();
        type = t;
    }

    /**
     * The constructor for building a new instance of a CardCollection
     * with given cards and actually no specific type!! 
     * @param cards the given cards to create a new CardCollection
     */
    public CardCollection(ArrayList<Card> cards)
    {
        this();
        this.cards.addAll(cards);
    }

     /**
     * @param type the type to set
     */
    public void setType(CardType type) {
        this.type = type;
    }
    
    /**
     * The round type to be returned! (Accessor)
 See CardType enumeration for further details
     * @return the round type
     */
    public CardType getType() {
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
    public boolean IsGreaterThan(CardCollection cCol) throws IncompatibleCardException
    {
        return false;
    }

   
    
}

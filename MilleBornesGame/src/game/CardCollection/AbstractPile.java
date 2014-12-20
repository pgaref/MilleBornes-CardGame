/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.CardCollection;

import game.Cards.Card;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * This card represent a collection of cards. Extensions of this
 * class could be card collection with special characteristics.
 * To this end, this class contain a method named getType which describe
 * the compatible type. Plz note that there is no transformer to the "type"
 * attribute. (Children override the accessor by returning type appropriately)
 * @author Author
 */
public abstract class AbstractPile 
{
    
    /** The cards. */
    public ArrayList<Card> cards;
    
    
  

    /**
     * Returns the arraylist of the cards belonging to this card collection.
     *
     * @return a arraylist of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Sets cards of the card collection (Transformer)
     * Postcondition: getCards() == cards.
     *
     * @param cards A arraylist of cards
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
    
    
	public void clearPile() {
		this.cards = new ArrayList<Card>();
	}

    
    /**
     * To be overidden. By default it returns false.
     * Calculates if this card collection is valid to be thrown over the given one (parameter)
     *
     * @param tmp the tmp
     * @return true if this card collection  has more power than parameter. Otherwise false.
     * @throws IncompatibleCardException the incompatible card exception
     */
    public boolean isValidMove(Card tmp) throws IncompatibleCardException
    {
        return false;
    }
    
    /**
     * Polymorphic method to add a card in the Pile. 
     * It is implemented seperately in each class
     * @param tmp which is a Card instance
     * @throws NotSupportedOperationException when the Card is not compatible with the Pile
     */
    public abstract void addCard(Card tmp) throws NotSupportedOperationException;
    
    /**
     * Method to remove a Card from the Pile
     * This method will be inhereted by every class extending AbstractPile.
     *
     * @param c the c
     * @return the card
     */
    public Card removeCard(Card c){
        for(int i =0 ; i < this.cards.size(); i++){
            if(this.cards.get(i).equals(c))
                return this.cards.remove(i);
        }
        System.out.println("Card: "+ c +" was not found!  ");
        return null;
        
    }

    /*
     * Returns  the last Card in the pile
     */
    public Card getLastCard(){
    	if(this.cards.size() >0)
    		return this.cards.get(this.cards.size()-1);
    	else{
    		System.out.println("Get last Card from Empty Pile!");
    		return null;
    	}
    }
   
    
}

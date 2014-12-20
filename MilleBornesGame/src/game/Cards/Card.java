/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Cards;

// TODO: Auto-generated Javadoc
/**
 * This abstract class represents a Card by encapsulating its attributes
 * such as its credits .
 *
 * @author Author
 */
public abstract class Card 
{
    
    /** The credits. */
    private double credits;
    
    /** The value. */
    private int value;
    
    /** The image path. */
    private String imagePath;

    
    
    /**
     * The Card Constructor which initializes with zero
     * both credits and value.
     */
    public Card() 
    {
        this.credits = 0;
        this.value = 0;
        this.imagePath = "";
    }

    /**
     * Returns the credits of the card (Accessor).
     *
     * @return the credits
     */
    public double getCredits() {
        return credits;
    }

    /**
     * Sets card credits (Transformer)
     * Postcondition: getCredits() == credits.
     *
     * @param credits The card credits!
     */
    public void setCredits(double credits) {
        this.credits = credits;
    }

    /**
     * Returns the value of the card (Accessor).
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets card value (Transformer)
     * Postcondition: getValue() == value.
     *
     * @param value The card value!
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    
    /**
     * Polymorphic function to check if one Card can be dropped on top of another.
     *
     * @param other Card to compare with
     * @return boolean
     */
    public abstract boolean match(Card other);

    /**
     * Gets the image path.
     *
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets the image path.
     *
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
    
}
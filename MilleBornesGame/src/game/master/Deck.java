/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.master;

import game.CardCollection.AbstractPile;
import game.CardCollection.DiscardPile;
import game.CardCollection.DrawPile;
import game.CardCollection.NotSupportedOperationException;
import game.Cards.Card;
import game.Cards.Distance;
import game.Player.Player;

// TODO: Auto-generated Javadoc
/**
 *  This class is representing the Deck of the Game,
 *  including the drawCards, discardCard and the two players.
 * 
 * @author Author
 */
public class Deck {
    
	/** The p2. */
	Player p1, p2;
	
    /** The draw cards. */
    private AbstractPile drawCards;
    
    /** The discard cards. */
    private AbstractPile discardCards;
    
    /**
     * Deck class constructor, initializing the two most basic Piles
     * and take the names of the two players as arguments.
     *
     * @param name1 the name1
     * @param name2 the name2
     */
    public Deck(String name1, String name2 ){
        this.discardCards = new DiscardPile();
        this.drawCards = new DrawPile();
        p1 = new Player(name1);
        p2 = new Player(name2);
        
        for(int i = 0 ; i < 50; i++){
                Card tmp = new Distance(75);
                try{
                    this.drawCards.addCard(tmp);
                    
                }catch(NotSupportedOperationException ex){
                    
                    ex.printStackTrace();
                }
        }
        
    }
    
    /**
     * A method to re-initialize the Deck by destroying the old Piles
     * and using the same player names. Also added a Check for null players!
     *
     * @throws Exception the exception
     */
    public void initializeAll() throws Exception{
        this.discardCards = null;
        this.drawCards = null;
        
        if(p1 == null || p2 == null)
        	throw new Exception("Cannot Initialize a Deck with null Player!");
        else
        	new Deck(this.p1.getName(), this.p2.getName());
    }
    
    /**
     * Gets the draw cards.
     *
     * @return the drawCards
     */
    public AbstractPile getDrawCards() {
        return drawCards;
    }

    /**
     * Sets the draw cards.
     *
     * @param drawCards the drawCards to set
     */
    public void setDrawCards(AbstractPile drawCards) {
        this.drawCards = drawCards;
    }

    /**
     * Gets the discard cards.
     *
     * @return the discardCards
     */
    public AbstractPile getDiscardCards() {
        return discardCards;
    }

    /**
     * Sets the discard cards.
     *
     * @param discardCards the discardCards to set
     */
    public void setDiscardCards(AbstractPile discardCards) {
        this.discardCards = discardCards;
    }

	/**
	 * Gets the p1.
	 *
	 * @return the p1
	 */
	public Player getP1() {
		return p1;
	}

	/**
	 * Sets the p1.
	 *
	 * @param p1 the p1 to set
	 */
	public void setP1(Player p1) {
		this.p1 = p1;
	}

	/**
	 * Gets the p2.
	 *
	 * @return the p2
	 */
	public Player getP2() {
		return p2;
	}

	/**
	 * Sets the p2.
	 *
	 * @param p2 the p2 to set
	 */
	public void setP2(Player p2) {
		this.p2 = p2;
	}
    
    
    
}

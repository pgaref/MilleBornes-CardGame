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
import game.Cards.Accident;
import game.Cards.Card;
import game.Cards.Distance;
import game.Cards.DrivingAce;
import game.Cards.ExtraTank;
import game.Cards.Gas;
import game.Cards.OutOfGas;
import game.Cards.EndOfSpeedLimit;
import game.Cards.Priority;
import game.Cards.PunctureProofTire;
import game.Cards.Repair;
import game.Cards.SpareTire;
import game.Cards.SpeedLimit;
import game.Cards.Start;
import game.Cards.Stop;
import game.Cards.FlatTire;
import game.Player.Player;

import java.util.ArrayList;
import java.util.Collections;

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
        
        ArrayList<Card> allCards = initAllCards();
        for(int i = 0 ; i < 6; i++){
        	p1.getHand().add(allCards.remove(allCards.size()-1));
        	p2.getHand().add(allCards.remove(allCards.size()-1));
        }
      
        //  p1.getSpeed().cards.add(new Distance(50));
        
        
        this.drawCards.setCards(allCards);
        
    }
    
    public ArrayList<Card> initAllCards(){
    	ArrayList<Card> all = new ArrayList<Card>();
    	
    	for(int i = 0 ; i < 106 ; i ++){
    		if(i < 10)
    			all.add( new Distance(25));
    		else if(i < 20)
    			all.add( new Distance(50));
    		else if(i < 30 )
    			all.add( new Distance(75));
    		else if( i < 42)
    			all.add( new Distance(100));
    		else if( i < 46)
    			all.add( new Distance(200));
    		else if( i < 47)
    			all.add( new DrivingAce());
    		else if( i < 48)
    			all.add( new ExtraTank());
    		else if( i < 49)
    			all.add( new PunctureProofTire());
    		else if( i < 50)
    			all.add( new Priority());
    		else if( i < 53)
    			all.add(new Accident());
    		else if( i < 56)
    			all.add(new OutOfGas());
    		else if ( i < 59)
    			all.add(new FlatTire());
    		else if( i < 64)
    			all.add(new Stop());
    		else if ( i < 68)
    			all.add(new SpeedLimit());
    		else if ( i < 74)
    			all.add(new Repair());
    		else if( i < 80)
    			all.add( new Gas());
    		else if ( i < 86)
    			all.add(new SpareTire());
    		else if( i < 100)
    			all.add(new Start());
    		else
    			all.add(new EndOfSpeedLimit());
    	}
    	Collections.shuffle(all);
    	return all;
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
    
	public String toString(){
		
		StringBuffer tmp = new StringBuffer();
		
		tmp.append("------ Draw Deck-------\n");
		tmp.append(this.drawCards.cards.size() + "\n");
		
		tmp.append("------ Discard Deck-------\n");
			tmp.append(this.discardCards.cards.size() + "\n");
		
		tmp.append( "------ P1 --------\n");
		tmp.append( this.p1.toString() );
		
		tmp.append( "------ P2 --------\n");
		tmp.append( this.p2.toString() );
	
		return tmp.toString();

	}
    
    
}

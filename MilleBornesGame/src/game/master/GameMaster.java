/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.master;

import game.Cards.Card;
import game.Cards.Distance;
import game.Player.Player;
import game.view.client.IGameClient;

import javax.swing.JFrame;

// TODO: Auto-generated Javadoc
/**
 *  This class is responsible to start the Game using all the classes needed from the Game Model.
 *  Meaning this is the class the Controller will call to connect it with the view.
 * 
 * @author Author
 */
public class GameMaster implements Game{

    
    /** The client. */
    private IGameClient client;
    
    /** The curr player. */
    private Player currPlayer;
    
    /** The state. */
    private GameState state;
    
    /** The Winner. */
    private Player Winner;
    
    /** The last played. */
    private Player lastPlayed;
    
    /** The deck. */
    private Deck deck;
    
    /** The view. */
    JFrame view;
    
    
    
    /**
     * Instantiates a new game master.
     *
     * @param c the c
     * @param one the one
     * @param two the two
     */
    public GameMaster(IGameClient c, String one, String two) {
    	
        this.deck = new Deck(one, two);
        
        this.state = GameState.WAITFORNAMES;
        
        this.currPlayer = deck.getP1();
        
        this.client = c;
    }

    /**
     * Instantiates a new game master.
     *
     * @param one the one
     * @param two the two
     */
    public GameMaster(String one, String two) {
    	
        this.deck = new Deck(one, two);
        System.out.println("~~ Init GameMaster: \n"+ deck.toString());
        
        this.state = GameState.WAITFORNAMES;
        
        this.currPlayer = deck.getP1();
    }
    
    /**
     * Instantiates a new game master.
     *
     * @param one the one
     * @param two the two
     * @param v the v
     */
    public GameMaster(String one, String two, JFrame v) {
    	
        this.deck = new Deck(one, two);
        
        this.state = GameState.WAITFORNAMES;
        
        this.currPlayer = deck.getP1();
        this.view = v;
    }
    
    
    /**
     * This method accepts the "pass" choice of a player.
     *
     * @param p The player who said "pass"
     * @return true if succeeded
     */
    public boolean playerSelectsToPass(Player p)
    {
        return false;
    }
    
    /**
     * The method that implements the basic game logic.
     *
     * In this method
     * @param p The player who dropped a  cards
     * @param c The card
     * @return true if card was valid, otherwise false
     */
    public boolean playerSubmitsCard(Player p, Card c)
    {
        return false;
    }

    
    
    /* (non-Javadoc)
     * @see game.master.Game#Start()
     */
    @Override
    public void Start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* (non-Javadoc)
     * @see game.master.Game#Stop()
     */
    @Override
    public void Stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* (non-Javadoc)
     * @see game.master.Game#Pause()
     */
    @Override
    public void Pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* (non-Javadoc)
     * @see game.master.Game#Resume()
     */
    @Override
    public void Resume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /* (non-Javadoc)
     * @see game.master.Game#Restart()
     */
    @Override
    public void Restart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Gets the first player.
     *
     * @return the first player
     */
    public Player getFirstPlayer() {
        return deck.getP1();
    }

    /**
     * Gets the second player.
     *
     * @return the second player
     */
    public Player getSecondPlayer() {
        return deck.getP2();
    }

    /**
     * Gets the current player.
     *
     * @return the current player
     */
    public Player getCurrentPlayer() {
        return currPlayer;
    }
    

	/**
	 * Gets the curr player.
	 *
	 * @return the currPlayer
	 */
	public Player getCurrPlayer() {
		return currPlayer;
	}


	/**
	 * Sets the curr player.
	 *
	 * @param currPlayer the currPlayer to set
	 */
	public void setCurrPlayer(Player currPlayer) {
		this.currPlayer = currPlayer;
	}


	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public GameState getState() {
		return state;
	}


	/**
	 * Sets the state.
	 *
	 * @param state the state to set
	 */
	public void setState(GameState state) {
		this.state = state;
	}


	/**
	 * Gets the winner.
	 *
	 * @return the winner
	 */
	public Player getWinner() {
		return Winner;
	}


	/**
	 * Sets the winner.
	 *
	 * @param winner the winner to set
	 */
	public void setWinner(Player winner) {
		Winner = winner;
	}


	/**
	 * Gets the last played.
	 *
	 * @return the lastPlayed
	 */
	public Player getLastPlayed() {
		return lastPlayed;
	}


	/**
	 * Sets the last played.
	 *
	 * @param lastPlayed the lastPlayed to set
	 */
	public void setLastPlayed(Player lastPlayed) {
		this.lastPlayed = lastPlayed;
	}


	/**
	 * Gets the deck.
	 *
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}


	/**
	 * Sets the deck.
	 *
	 * @param deck the deck to set
	 */
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
    
}

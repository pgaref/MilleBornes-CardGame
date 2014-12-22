/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.master;

import game.CardCollection.NotSupportedOperationException;
import game.Cards.Card;
import game.Cards.Distance;
import game.Cards.Hazard;
import game.Cards.Priority;
import game.Cards.Remedy;
import game.Cards.Safety;
import game.Cards.SpeedLimit;
import game.Cards.Start;
import game.Cards.Stop;
import game.Player.Player;
import game.view.client.IGameClient;

import javax.swing.JFrame;

/**
 *  This class is responsible to start the Game using all the classes needed from the Game Model.
 *  Meaning this is the class the Controller will call to connect it with the view.
 * 
 * @author Author
 */
public class GameMaster{

    
    /** The client. */
    private IGameClient client;
    
    /** The current player. */
    private Player currPlayer;
    
    /** The Winner. */
    private Player Winner;
    
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
        
        this.currPlayer = deck.getP1();
        
        this.client = c;
    }
    
    
    /**
     * This method accepts the "pass" choice of a player.
     *
     * @param p The player who said "pass"
     * @return true if succeeded
     */
    public boolean playerSelectsToPass()
    {
    	if(this.currPlayer.getHand().size()>6){
    		System.out.println("You have to discard a Card!!");
    		return false;
    	}
    	else{
    		this.currPlayer=this.getNextPlayer();
    		System.out.println("Changing player to: "+ this.currPlayer.getName());
    	}
    	return true;
    }
    

	public boolean playerDiscardsCard(Card card) {
		
		if(card == null){
			System.out.println("Cannot through NULL card! Pick a card!");
			return false;
		}
		
		if(this.currPlayer.canDiscardCard() && this.currPlayer.getHand().size()>=1){
			this.currPlayer.getHand().remove(card);	
			this.deck.getDiscardCards().cards.add(card);
			
			this.currPlayer=this.getNextPlayer();
			this.client.changePlayer();
    		System.out.println("Changing player to: "+ this.currPlayer.getName());
			return true;
		}
		return false;
	}
    
    /**
     * The method that implements the basic game logic.
     *
     * In this method
     * @param p The player who dropped a  cards
     * @param c The card
     * @return true if card was valid, otherwise false
     * @throws NotSupportedOperationException 
     */
    public boolean playerSubmitsCard(Card c) throws NotSupportedOperationException
    {
    	boolean foundMatch = false;
    	/**
		 * ALL Game Rules that have to do with card matchings go here!!!
		 */
		
    	if(c instanceof Distance){
    		if(this.currPlayer.canThrowMileCard(c)){
    			
    			this.currPlayer.getHand().remove(c);
    			this.currPlayer.getDistance().addCard(c);
    			this.currPlayer.addMilesRun(c.getValue());
    			foundMatch = true;
    		}
    		
    	}
    	else if(c instanceof Safety ){
    		this.currPlayer.getSafety().addCard(c);
    		this.currPlayer.getHand().remove(c);
    		
    		//Empty Piles Case
    		if((this.currPlayer.getBattle().cards.isEmpty()) && (this.currPlayer.getSpeed().cards.isEmpty())  ){
    			this.currPlayer.setCanMove(true);
    			if(c instanceof Priority)
    				this.currPlayer.setHasStarted(true);
    		}
    		//Check for possible fixes at Battle Pile
    		else if((!this.currPlayer.getBattle().cards.isEmpty()) && (c.match(this.currPlayer.getBattle().getLastCard()))){
    			this.currPlayer.getBattle().addCard(c);
    			this.currPlayer.setCanMove(true);
    			if(c instanceof Priority)
    				this.currPlayer.setHasStarted(true);
    		}
    		//Check the Speed Pile too
    		else if((!this.currPlayer.getSpeed().cards.isEmpty()) && (c.match(this.currPlayer.getSpeed().getLastCard()))){
    			this.currPlayer.getSpeed().clearPile();
    			this.currPlayer.setCanMove(true);
    			if(c instanceof Priority)
    				this.currPlayer.setHasStarted(true);
    		}
    		
    		foundMatch = true;
    	}
    	
    	else if(c instanceof Hazard ){
    		Player other = this.getNextPlayer();
    		

    		//Check if it eligible to throw a Hazard card according to the rules!
    		if(!(other.hasStarted()) && (other.getBattle().getCards().isEmpty()) && !(other.hasPriorityCard()) &&( !(c instanceof SpeedLimit ))){
    			System.out.println("Not eligible to throw a Hazard card!!!");
    			return false;
    		}
    		//Check if there is a safety card preventing us to throw the card!
    		for(Card tmp : other.getSafety().getCards()){
    			if(tmp.match(c)){
    				System.out.println("Safety Card prevents that action!!!");
    				return false;
    			}
    		}
    		//Check if Card is Speed Limit 
    		if(c instanceof SpeedLimit){
    			other.setCanMove(true);
    			other.getSpeed().addCard(c);
    			this.currPlayer.getHand().remove(c);
    		}
    		//In any other case
    		else{
    			
    			other.setCanMove(false);
    			other.setHasStarted(false);
    			other.getBattle().addCard(c);
    			this.currPlayer.getHand().remove(c);
    			
    		}
    		
    		this.currPlayer=this.getNextPlayer();
    		this.client.changePlayer();
    		System.out.println("Changing player to: "+ this.currPlayer.getName());
    		return true;
    		
    	}
    	else if(c instanceof Remedy ){
    		
    		//Start Card case is different since we need to change player info!
    		if(c instanceof Start && (this.currPlayer.hasStarted()==false) ){
    			if(this.currPlayer.getBattle().getCards().isEmpty()){
    				this.currPlayer.setHasStarted(true);
    				this.currPlayer.setCanMove(true);
    				this.currPlayer.getBattle().addCard(c);
    				this.currPlayer.getHand().remove(c);
    				foundMatch = true;
    			}
    			//Start Card matches with Stop at Battle Pile
    			else if(this.currPlayer.getBattle().getLastCard() instanceof Stop){
    				this.currPlayer.setHasStarted(true);
    				this.currPlayer.getBattle().addCard(c);
    				this.currPlayer.getHand().remove(c);
    				foundMatch = true;
    			}
    			else if(! (this.currPlayer.getBattle().getLastCard() instanceof Hazard)){
    				this.currPlayer.setHasStarted(true);
    				this.currPlayer.getBattle().addCard(c);
    				this.currPlayer.getHand().remove(c);
    				foundMatch = true;
    			}
    			
    		}
    		else if( (!this.currPlayer.getBattle().getCards().isEmpty()) && (c.match(this.currPlayer.getBattle().getLastCard())) ){
    			
    			this.currPlayer.getBattle().addCard(c);
    			this.currPlayer.getHand().remove(c);
    			foundMatch = true;
    		}
    		else if((!this.currPlayer.getSpeed().getCards().isEmpty()) && (c.match(this.currPlayer.getSpeed().getLastCard())) ){
    			
    			this.currPlayer.getHand().remove(c);
    			this.currPlayer.getSpeed().clearPile();
    			this.currPlayer.setCanMove(true);
    			foundMatch = true;
    		}
    		
    	}
    	
    	
    	if(foundMatch && (c instanceof Safety)){
    		return true;
    	}
    	if(foundMatch && !(c instanceof Safety)){
    		
    		this.currPlayer=this.getNextPlayer();
    		this.client.changePlayer();
    		System.out.println("Changing player to: "+ this.currPlayer.getName());
    		return true;
    	}
    	else
    		return false;
	}

	/**
	 * The method that implements the basic draw Card logic.
	 *
	 * In this method
	 * 
	 * @return true if card was drawn, otherwise false
	 */
    public boolean playerDrawCard(){
    	
    	//If there are no cards left at the Draw Pile!
    	if(this.deck.getDrawCards().getCards().isEmpty()){
    		this.currPlayer.sethasDrawnCard(true);
    		return true;
    	}
    	//In any other case
    	else if(!this.currPlayer.hasDrawnCard() && (this.currPlayer.getHand().size() == 6)){
    		Card tmp = this.deck.getDrawCards().getCards().remove(this.deck.getDrawCards().getCards().size()-1);
    		this.currPlayer.getHand().add(tmp);
    		this.currPlayer.sethasDrawnCard(true);
    		return true;
    	}
    	return false;
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
    
    public Player getNextPlayer(){
    	if(this.currPlayer .getName().compareTo( deck.getP1().getName()) ==0)
			return deck.getP2();
		else
			return deck.getP1();
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

	
	public IGameClient  getGameClient(){
		return this.client;
	}
    
}

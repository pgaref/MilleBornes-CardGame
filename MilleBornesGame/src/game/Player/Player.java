/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Player;

import game.CardCollection.AbstractPile;
import game.CardCollection.BattlePile;
import game.CardCollection.DistancePile;
import game.CardCollection.SafetyPile;
import game.CardCollection.SpeedPile;
import game.Cards.Card;
import game.Cards.Distance;
import game.Cards.Hazard;
import game.Cards.Priority;

import java.util.ArrayList;

/**
 * This class represents one Player of the Card game.
 * Contaids information such as players name, the 4 different piles and the temporary card!
 * @author Author
 */
public class Player {
    
    
    /** The name. */
    private String name;
    
    /** The Miles run. */
    private int MilesRun;
    
    /** The hand. */
    private ArrayList<Card> hand;
    private AbstractPile battle;
    private AbstractPile speed;
    private AbstractPile distance;
    private AbstractPile satefy;
    
    
    /** The has started. */
    private boolean hasStarted;
    
    /** The state. */
    private boolean canMove;
    
    /** The player has drawn a card in this round! */
    private boolean hasDrawn;
    
    /**
     * Player Class constructor.
     *
     * @param name of the player
     */
    public Player(String name){
        this.name = name;
        this.MilesRun = 0; 
        this.hasStarted=false;
        this.hasDrawn = false;
        this.canMove = true;
        
        this.hand = new ArrayList<Card>();
        
        this.speed = new SpeedPile();
        this.distance = new DistancePile();
        this.battle = new BattlePile();
        this.satefy = new SafetyPile();
        
    }
	
	/**
	 * Getter method for the name of the Player.
	 *
	 * @return the name
	 */
    public String getName() {
        return this.name;
    }
    
    /**
     * Getter Method for the handPilr of the player.
     *
     * @return the players hand
     */
    public ArrayList<Card> getPlayersHand() {
        return this.getHand();
    }
    
    /**
     * Setter method for the handPile of the method.
     *
     * @param c the c
     */
    public void addHandCard(Card c){
        this.getHand().add(c);
    }
    
    /**
     * Observer method.
     *
     * @param c the c
     * @return true, if is winner
     */
    public boolean isWinner(Card c){
        if(getMilesRun() + c.getValue() ==1000)
            return true;
        else
            return false;
    }
    
    /**
     * Observer method.
     *
     * @param c the c
     * @return true, if successful
     */
    public boolean canThrowMileCard(Card c){
    	
    	/**
    	 * Player rules to throw Distance Card
    	 */
    	
    	//Wrong Card case
    	if(!(c instanceof Distance)){
    		System.out.println("This is not a Distane Card!!!");
    		return false;
    	}
    	
    	//Not started && without priority card case!
    	if( (this.hasStarted == false) && (this.hasPriorityCard() == false) ){
    		System.out.println("You need a Roll/Priority Card to start playing!");
    		return false;
    	}
    	//There is a Hazard in the Battle Pile!!
    	if(this.hasHazard() == true){
    		System.out.println("You need to fix that Hazard first!!!");
    		return false;
    	}
    	//There is a Speed limit case
    	if(!this.getSpeed().getCards().isEmpty() && (c.getValue()>50)){
    		System.out.println("There is a Speed Limit! Select less than 50 miles Card!");
    		return false;
    	}
    	//More than 1k case
    	if(getMilesRun() + c.getValue() > 1000){
            System.out.println("The total Miles cannot be more than 1000!!!!");
    		return false;
    	}
    	
    	
        //Up to 2  -> 200 miles Cards allowed!
    	if( (c.getValue() == 200) && (this.topMileCounter() <2) )
    			return true;
    	else if((c.getValue() == 200) && (this.topMileCounter() >=2) ){
    		System.out.println("Cannot throw more than 2, 200Mile Cards!!");
    		return false;
    	}
    	
        
        
        
        return true;        
    }
    private boolean hasHazard() {
		if((this.getBattle().getCards().isEmpty()))
			return false;
		if ((this.getBattle().getLastCard() instanceof Hazard))
			return true;
		return false;
	}

	public boolean hasPriorityCard() {

    	for(Card tmp : this.getSatefy().getCards()){
    		if(tmp instanceof Priority)
    			return true;
    	}
		return false;
	}

	/**
     * Method to count 200 Mile Cards!
     * @return
     */
    public int topMileCounter(){
    	int count  = 0 ;
    	for(Card  c : this.distance.getCards()){
    		if(c.getValue() ==200)
    			count++;
    	}
    	return count;
    }
    
    public boolean canDiscardCard(){	
    	if(this.hasDrawn)
    		return true;
    	else 
    		return false;
    }
    
    
    /**
     * Observer method.
     *
     * @return true, if is able to move
     */
    public boolean isAbleToMove(){
        return this.getBattle().getCards().size() > 0;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the miles run.
     *
     * @return the MilesRun
     */
    public int getMilesRun() {
        return MilesRun;
    }

    /**
     * Sets the miles run.
     *
     * @param MilesRun the MilesRun to set
     */
    public void addMilesRun(int MilesRun) {
        this.MilesRun += MilesRun;
    }

    /**
     * Gets the hand.
     *
     * @return the hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * Sets the hand.
     *
     * @param hand the hand to set
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * Gets the battle.
     *
     * @return the battle
     */
    public AbstractPile getBattle() {
        return battle;
    }

    /**
     * Sets the battle.
     *
     * @param battle the battle to set
     */
    public void setBattle(AbstractPile battle) {
        this.battle = battle;
    }

    /**
     * Gets the speed.
     *
     * @return the speed
     */
    public AbstractPile getSpeed() {
        return speed;
    }

    /**
     * Sets the speed.
     *
     * @param speed the speed to set
     */
    public void setSpeed(AbstractPile speed) {
        this.speed = speed;
    }

    /**
     * Gets the distance.
     *
     * @return the distance
     */
    public AbstractPile getDistance() {
        return distance;
    }

    /**
     * Sets the distance.
     *
     * @param distance the distance to set
     */
    public void setDistance(AbstractPile distance) {
        this.distance = distance;
    }

    /**
     * Gets the satefy.
     *
     * @return the satefy
     */
    public AbstractPile getSatefy() {
        return satefy;
    }

    /**
     * Sets the satefy.
     *
     * @param satefy the satefy to set
     */
    public void setSatefy(AbstractPile satefy) {
        this.satefy = satefy;
    }

    /**
     * Checks if is checks for started.
     *
     * @return the hasStarted
     */
    public boolean hasStarted() {
        return hasStarted;
    }

    /**
     * Sets the checks for started.
     *
     * @param hasStarted the hasStarted to set
     */
    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }
	

    public boolean canMove(){
    	return this.canMove;
    }
    
    public void setCanMove(boolean b){
    	this.canMove = b;
    }
	


	public boolean hasDrawnCard() {
		return hasDrawn;
	}
	
	public void changeDrawnCard(boolean b) {
		this.hasDrawn = b;
	}
	
	public String toString(){
		StringBuffer tmp  = new StringBuffer();
		tmp.append(" Hand: ");
		for(Card c: this.getHand() )
			tmp.append(c+"\n");
		
		tmp.append( "\n Safety: ");
		for(Card c: this.getSatefy().cards )
			tmp.append( c+"\n" );

		tmp.append( "\n Distance: ");
		for(Card c: this.getDistance().cards )
			tmp.append( c+"\n") ;
		
		tmp.append("\n Battle: ");
		for(Card c: this.getBattle().cards )
			tmp.append( c+"\n" );
		
		tmp.append( "\n Speed: ");
		for(Card c: this.getSpeed().cards )
			tmp.append( c+"\n") ;
		
		return tmp.toString();
	}
	
    
    
    
    
}

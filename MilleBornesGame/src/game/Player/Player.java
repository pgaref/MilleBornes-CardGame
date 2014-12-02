/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Player;

import game.CardCollection.BattlePile;
import game.CardCollection.AbstractPile;
import game.CardCollection.DistancePile;
import game.CardCollection.SafetyPile;
import game.CardCollection.SpeedPile;
import game.Cards.Card;
import game.Cards.Distance;

// TODO: Auto-generated Javadoc
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
    private AbstractPile hand;
    
    /** Players Piles!. */
    private AbstractPile battle;
    
    /** The speed. */
    private AbstractPile speed;
    
    /** The distance. */
    private AbstractPile distance;
    
    /** The satefy. */
    private AbstractPile satefy;
    
    /** The tmp. */
    private Card tmp;
    
    /** The has started. */
    private boolean hasStarted;
    
    /** The state. */
    private boolean state;
    
    /**
     * Player Class constructor.
     *
     * @param name of the player
     */
    public Player(String name){
        this.name = name;
        this.MilesRun = 0; 
        this.hasStarted=false;
        this.hand = new DistancePile();
        
        this.speed = new SpeedPile();
        this.distance = new DistancePile();
        this.battle = new BattlePile();
        this.satefy = new SafetyPile();
        this.tmp = null;
        
        this.hand.getCards().add(new Distance(75));
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
    public AbstractPile getPlayersHand() {
        return this.getHand();
    }
    
    /**
     * Setter method for the handPile of the method.
     *
     * @param c the c
     */
    public void addHandCard(Card c){
        this.getHand().getCards().add(c);
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
        if(!(c instanceof Distance))
                return false;
        if(getMilesRun() + c.getValue() > 1000)
            return false;
        return true;        
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
    public void setMilesRun(int MilesRun) {
        this.MilesRun = MilesRun;
    }

    /**
     * Gets the hand.
     *
     * @return the hand
     */
    public AbstractPile getHand() {
        return hand;
    }

    /**
     * Sets the hand.
     *
     * @param hand the hand to set
     */
    public void setHand(AbstractPile hand) {
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
    public boolean isHasStarted() {
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

    /**
     * Checks if is state.
     *
     * @return the state
     */
    public boolean isState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the state to set
     */
    public void setState(boolean state) {
        this.state = state;
    }
	
	/**
	 * Gets the tmp.
	 *
	 * @return the tmp
	 */
	public Card getTmp() {
		return tmp;
	}
	
	/**
	 * Sets the tmp.
	 *
	 * @param tmp the tmp to set
	 */
	public void setTmp(Card tmp) {
		this.tmp = tmp;
	}
    
    
    
    
}

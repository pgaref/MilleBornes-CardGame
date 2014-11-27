/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Player;

import game.CardCollection.BattlePile;
import game.CardCollection.CardPile;
import game.CardCollection.DistancePile;
import game.CardCollection.SafetyPile;
import game.CardCollection.SpeedPile;
import game.Cards.Card;
import game.Cards.Distance;

/**
 *
 * @author Author
 */
public class Player {
    
    
    private String name;
    private int MilesRun;
    
    private CardPile hand;
    
    /**
     * Players Piles!
     */
    private CardPile battle;
    private CardPile speed;
    private CardPile distance;
    private CardPile satefy;
    
    private Card tmp;
    
    private boolean hasStarted;
    private boolean state;
    
    public Player(String name){
        this.name = name;
        this.MilesRun = 0; 
        this.hasStarted=false;
        this.hand = new CardPile(6);
        
        this.speed = new SpeedPile();
        this.distance = new DistancePile();
        this.battle = new BattlePile();
        this.satefy = new SafetyPile();
        this.tmp = null;
        
        this.hand.getCards().add(new Distance(75));
    }

    public String getName() {
        return this.name;
    }

    public CardPile getPlayersHand() {
        return this.getHand();
    }
    
    public void addHandCard(Card c){
        this.getHand().getCards().add(c);
    }
    
    
    public boolean isWinner(Card c){
        if(getMilesRun() + c.getValue() ==1000)
            return true;
        else
            return false;
    }
    
    public boolean canThrowMileCard(Card c){
        if(!(c instanceof Distance))
                return false;
        if(getMilesRun() + c.getValue() > 1000)
            return false;
        return true;        
    }
    
    public boolean isAbleToMove(){
        return this.getBattle().getCards().size() > 0;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the MilesRun
     */
    public int getMilesRun() {
        return MilesRun;
    }

    /**
     * @param MilesRun the MilesRun to set
     */
    public void setMilesRun(int MilesRun) {
        this.MilesRun = MilesRun;
    }

    /**
     * @return the hand
     */
    public CardPile getHand() {
        return hand;
    }

    /**
     * @param hand the hand to set
     */
    public void setHand(CardPile hand) {
        this.hand = hand;
    }

    /**
     * @return the battle
     */
    public CardPile getBattle() {
        return battle;
    }

    /**
     * @param battle the battle to set
     */
    public void setBattle(CardPile battle) {
        this.battle = battle;
    }

    /**
     * @return the speed
     */
    public CardPile getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(CardPile speed) {
        this.speed = speed;
    }

    /**
     * @return the distance
     */
    public CardPile getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(CardPile distance) {
        this.distance = distance;
    }

    /**
     * @return the satefy
     */
    public CardPile getSatefy() {
        return satefy;
    }

    /**
     * @param satefy the satefy to set
     */
    public void setSatefy(CardPile satefy) {
        this.satefy = satefy;
    }

    /**
     * @return the hasStarted
     */
    public boolean isHasStarted() {
        return hasStarted;
    }

    /**
     * @param hasStarted the hasStarted to set
     */
    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    /**
     * @return the state
     */
    public boolean isState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(boolean state) {
        this.state = state;
    }
    
    
    
    
}

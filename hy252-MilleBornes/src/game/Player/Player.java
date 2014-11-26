/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Player;

import game.CardCollection.CardCollection;
import game.Cards.Card;
import game.Cards.Distance;
import game.Cards.Type.CardType;

/**
 *
 * @author pg1712
 */
public class Player {
    
    
    private String name;
    private int Miles;
    
    private CardCollection hand;
    private CardCollection battle;
    private CardCollection speed;
    private CardCollection distance;
    private Card tmp;
    
    boolean hasStarted;
    boolean state;
    
    public Player(String name){
        this.name = name;
        this.Miles = 0; 
        this.hasStarted=false;
        this.hand = new CardCollection(CardType.UNGATEGORIZED, 6);
        this.speed = new CardCollection(CardType.SPEED);
        this.distance = new CardCollection(CardType.DISTANCE);
        this.battle = new CardCollection(CardType.BATTLE);
        this.tmp = null;
        
        this.hand.getCards().add(new Distance(75));
    }

    public String getName() {
        return this.name;
    }

    public CardCollection getPlayersHand() {
        return this.hand;
    }
    
    public void addHandCard(Card c){
        this.hand.getCards().add(c);
    }
    
    
}

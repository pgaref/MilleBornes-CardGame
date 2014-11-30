/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.master;

import game.CardCollection.CardPile;
import game.Cards.Card;
import game.Cards.Distance;
import game.Cards.Type.CardType;
import game.Player.Player;
import game.view.frame.MainGameFrame;
import java.util.ArrayList;

/**
 *
 * @author pg1712
 * 
 */
public class GameMaster implements Game{

    
    
    private Player p1;
    private Player p2;
    private Player currPlayer;
    private ArrayList<Player> players;
    private GameState state;
    private Player Winner;
    private Player lastPlayed;
    
    private Deck table;
    
    

    public GameMaster(String one, String two) {
        this.p1 = new Player(one);
        this.p2 = new Player(two);
        this.table = new Deck();
        
        
        this.players = new ArrayList<Player>(2);
        players.add(p1);
        players.add(p2);
        
        this.state = GameState.WAITFORNAMES;

        
        this.currPlayer = p1;
    }
    
    
    @Override
    public void Start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Resume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Restart() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Player getFirstPlayer() {
        return p1;
    }

    public Player getSecondPlayer() {
        return p2;
    }

    public Player getCurrentPlayer() {
        return currPlayer;
    }
    

    public void initialiazePlayersWithSixCards() {
       for(int i = 0 ; i < 6; i++){
                Card tmp = new Distance(75);
                p1.addHandCard(tmp);
       }
       
       for(int i = 0 ; i < 6; i++){
                Card tmp = new Distance(75);
                p2.addHandCard(tmp);
       }
        
    }
    
}

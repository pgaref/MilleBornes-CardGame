/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.panels;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import game.Cards.*;
import game.Player.Player;
import game.CardCollection.*;
import game.master.GameMaster;

/**
 *
 * @author Dimitris
 */
public class PlayersPanel extends JPanel {
    
    private HorizontalViewCardPanel up;
    private HorizontalViewCardPanel down;
    private CenterPanel center;
    
    private ViewCardPanel activepanel = null;
    
    private GameMaster game;
    
    public PlayersPanel(GameMaster _game){
        super();
        this.game = _game;
        center = new CenterPanel(this.game,this);
        this.setLayout(new BorderLayout());
        this.addPanels();
        this.add(center, BorderLayout.CENTER);
    }
    
    
    private void addPanels(){
        if(up != null && down != null ){
            this.remove(up);
            this.remove(down);
        }
        this.down = new HorizontalViewCardPanel(game.getFirstPlayer(), false);
        this.up = new HorizontalViewCardPanel(game.getSecondPlayer(), true);
        
        
        this.add(up, BorderLayout.PAGE_START);
        this.add(down, BorderLayout.PAGE_END);

    }
    
    
    public void clearAll(){
        center.clearAll();
    }
    
    public void findCurrentPlayer(){
        Player current = game.getCurrentPlayer();
        
        if(up.getPlayer().getName().equals(current.getName())){
            activepanel = up;
            up.changeCurrentPlayerColor();
            down.HideCards();

        }
        else if(down.getPlayer().getName().equals(current.getName())){
            activepanel = down;
            down.changeCurrentPlayerColor();;
            up.HideCards();
        }
        
        activepanel.changePlayer(current);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon back = new ImageIcon(getClass().getResource("/game/images/background.jpg"));
        g.drawImage(back.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public ArrayList<Card> getSelectedCards(){
        return activepanel != null ? activepanel.getSelectedCards() : null;
    }
    
    public void makeMahjongPanel(Card c){
        center.showMahjongPanel(c,activepanel.getPlayer());
    }

    public void setCards(CardPile comb) {
        center.setCards(comb);
    }
}

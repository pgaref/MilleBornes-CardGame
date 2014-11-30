/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.panels;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import game.Cards.*;
import game.Player.Player;
import game.CardCollection.*;
import game.master.GameMaster;
import java.awt.Color;
import java.awt.GridBagLayout;

/**
 *
 * @author Dimitris
 */
public class PlayersPanel extends JPanel {
    
    private HorizontalViewCardPanel up;
    private HorizontalViewCardPanel up2;
    private HorizontalViewCardPanel down;
    private HorizontalViewCardPanel down2;
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
            this.remove(up2);
            this.remove(down);
            this.remove(down2);
        }
        this.down = new HorizontalViewCardPanel(game.getFirstPlayer(), false);
        this.down2 = new HorizontalViewCardPanel(game.getFirstPlayer(), false);
        this.up = new HorizontalViewCardPanel(game.getSecondPlayer(), true);
        this.up2 = new HorizontalViewCardPanel(game.getSecondPlayer(), true);
        
 
        
        JPanel doublePanel1 = new JPanel();
        doublePanel1.setLayout( new BorderLayout());
        doublePanel1.add(down, BorderLayout.PAGE_START);
        doublePanel1.add(down2,BorderLayout.PAGE_END);
        doublePanel1.setBackground(Color.lightGray);
        this.add(doublePanel1, BorderLayout.PAGE_END);
        
//        this.add(up, BorderLayout.PAGE_START);
//        this.add(down, BorderLayout.LINE_END);
//        this.add(down2);
        
        JPanel doublePanel2 = new JPanel();
        doublePanel2.setLayout( new BorderLayout());
        doublePanel2.add(up, BorderLayout.PAGE_START);
        doublePanel2.add(up2,BorderLayout.PAGE_END);
        doublePanel2.setBackground(Color.lightGray);
        this.add(doublePanel2, BorderLayout.PAGE_START);
        

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
            down2.HideCards();

        }
        else if(down.getPlayer().getName().equals(current.getName())){
            activepanel = down;
            down.changeCurrentPlayerColor();;
            down2.changeCurrentPlayerColor();
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
    

    public void setCards(CardPile comb) {
        center.setCards(comb);
    }
}

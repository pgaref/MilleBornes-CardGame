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

// TODO: Auto-generated Javadoc
/**
 * This class represents a Player Panel 
 * including the 2 different horizontal views for each player and the central panel.
 *
 * @author Author
 */
public class PlayersPanel extends JPanel {
    
    /** The up. */
    private HorizontalViewCardPanel up;
    
    /** The up2. */
    private HorizontalViewCardPanel up2;
    
    /** The down. */
    private HorizontalViewCardPanel down;
    
    /** The down2. */
    private HorizontalViewCardPanel down2;
    
    /** The center. */
    private CenterPanel center;
    
    /** The activepanel. */
    private ViewCardPanel activepanel = null;
    
    /** The game. */
    private GameMaster game;
    
    /**
     * Instantiates a new players panel.
     *
     * @param _game the _game
     */
    public PlayersPanel(GameMaster _game){
        super();
        this.game = _game;
        center = new CenterPanel(this.game,this);
        this.setLayout(new BorderLayout());
        this.addPanels();
        this.add(center, BorderLayout.CENTER);
    }
    
    
    /**
     * Adds the panels.
     */
    private void addPanels(){
        if(up != null && down != null ){
            this.remove(up);
            this.remove(up2);
            this.remove(down);
            this.remove(down2);
        }
        this.down = new HorizontalViewCardPanel(game.getFirstPlayer(), false, true);
        this.down2 = new HorizontalViewCardPanel(game.getFirstPlayer(), false);
        this.up = new HorizontalViewCardPanel(game.getSecondPlayer(), true);
        this.up2 = new HorizontalViewCardPanel(game.getSecondPlayer(), true, true);
        
 
        
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
    
    
    /**
     * Clear all.
     */
    public void clearAll(){
        center.clearAll();
    }
    
    /**
     * Find current player.
     */
    public void findCurrentPlayer(){
        Player current = game.getCurrentPlayer();
        
        if(up.getPlayer().getName().equals(current.getName())){
            activepanel = up;
            up.changeCurrentPlayerColor();
            up2.changeCurrentPlayerColor();
            
            down.HideCards();
            down2.HideCards();

        }
        else if(down.getPlayer().getName().equals(current.getName())){
            activepanel = down2;
            
            down.changeCurrentPlayerColor();;
            down2.changeCurrentPlayerColor();
            
            up.HideCards();
            up2.HideCards();
        }
        
        activepanel.changePlayer(current);
    }
    
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon back = new ImageIcon(getClass().getResource("/game/images/background.jpg"));
        g.drawImage(back.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    /**
     * Gets the selected cards.
     *
     * @return the selected cards
     */
    public Card getSelectedCard(){
    	if(activepanel != null && activepanel.getSelectedCards().size()==1)
    		return activepanel.getSelectedCards().get(0);
    	else
    		System.out.println("Just Select one Card!!!");
    	return null;
  
    }
    

    /**
     * Sets the cards.
     *
     * @param comb the new cards
     */
    public void setCards(AbstractPile comb) {
        center.setCards(comb);
    }
}

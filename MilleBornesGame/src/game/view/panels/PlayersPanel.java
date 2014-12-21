/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.panels;

import game.Cards.Card;
import game.Player.Player;
import game.master.GameMaster;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
    public void addPanels(){
        if(up != null && down != null ){
            this.remove(up);
            this.remove(up2);
            this.remove(down);
            this.remove(down2);
        }
        this.down = new HorizontalViewCardPanel(game.getFirstPlayer(), true);
        this.down2 = new HorizontalViewCardPanel(game.getFirstPlayer());
        this.up = new HorizontalViewCardPanel(game.getSecondPlayer());
        this.up2 = new HorizontalViewCardPanel(game.getSecondPlayer(), true);
        
        //Player 1 Starts!!!
        activepanel = down2;
        
        JPanel doublePanel1 = new JPanel();
        doublePanel1.setLayout( new BorderLayout());
        doublePanel1.add(down, BorderLayout.PAGE_START);
        doublePanel1.add(down2,BorderLayout.PAGE_END);
        doublePanel1.setBackground(Color.lightGray);
        this.add(doublePanel1, BorderLayout.PAGE_END);
        
        
        JPanel doublePanel2 = new JPanel();
        doublePanel2.setLayout( new BorderLayout());
        doublePanel2.add(up, BorderLayout.PAGE_START);
        doublePanel2.add(up2,BorderLayout.PAGE_END);
        doublePanel2.setBackground(Color.lightGray);
        this.add(doublePanel2, BorderLayout.PAGE_START);
        

    }
    
    
    /**
     * Change current player Turn
     */
    public void changePlayerTurn(){
        Player current = game.getCurrentPlayer();
        current.changeDrawnCard(false);
        
        if(up.getPlayer().getName().equals(current.getName())){
            activepanel = up;
            
            up.paintHandCards();
            up2.paintExtraPileCards();
            up.changeCurrentPlayerColor();
            up2.changeCurrentPlayerColor();
            
            down.HideCards(true);
            down2.HideCards();

        }
        else if(down.getPlayer().getName().equals(current.getName())){
            activepanel = down2;
            
            down.paintExtraPileCards();
        	down2.paintHandCards();
            down.changeCurrentPlayerColor();;
            down2.changeCurrentPlayerColor();
            
            up.HideCards();
            up2.HideCards(true);
        }
        
        activepanel.changePlayer(current);
    }
    
    
    /**
     *  current player Draw Card
     */
    public void currPlayerDraw(){
    	
        Player current = game.getCurrentPlayer();
        
        if(up.getPlayer().getName().equals(current.getName())){
            
        	up.paintHandCards();
            up2.paintExtraPileCards();
        }
        else if(down.getPlayer().getName().equals(current.getName())){
            
        	down.paintExtraPileCards();
        	down2.paintHandCards();
            
        }
    }
    
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
    public void setCards(Card comb) {
        center.setCard(comb);
    }
}

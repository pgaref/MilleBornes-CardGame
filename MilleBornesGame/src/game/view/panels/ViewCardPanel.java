/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.panels;

import game.Cards.Card;
import game.Player.Player;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

// TODO: Auto-generated Javadoc
/**
 * This class represents a Panel for displaying the Cards
 * The oponnent cards will be displayed in Mirror.
 *
 * @author Author
 */

public class ViewCardPanel extends JLayeredPane {
    
    /** The player. */
    private Player player;
    
    /** The is mirror. */
    private boolean isMirror;
    
    /** The image_dir. */
    private String image_dir;
    
    /** The name. */
    protected JLabel name;
    
    /**
     * Instantiates a new view card panel.
     *
     * @param _player the _player
     * @param _isMirror the _is mirror
     */
    public ViewCardPanel(Player _player,boolean _isMirror){
        this.player = _player;
        this.isMirror = _isMirror;
        name = new JLabel(_player.getName());
    }
    
   /**
    * Instantiates a new view card panel.
    *
    * @param _isMirror the _is mirror
    */
   public ViewCardPanel(boolean _isMirror){
        this.player = null;
        this.isMirror = _isMirror;
    }
    
    /**
     * Change current player color.
     */
    public void changeCurrentPlayerColor(){
        name.setForeground(Color.YELLOW);
    }
    
    /**
     * Change player.
     *
     * @param p the p
     */
    public void changePlayer(Player p){}
    
    /**
     * Show cards.
     */
    public void showCards(){}

    /**
     * Gets the player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sets the player.
     *
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Gets the image_dir.
     *
     * @return the image_dir
     */
    public String getImage_dir() {
        return image_dir;
    }

    /**
     * Sets the image_dir.
     *
     * @param image_dir the image_dir to set
     */
    public void setImage_dir(String image_dir) {
        this.image_dir = image_dir;
    }

    /**
     * Checks if is checks if is mirror.
     *
     * @return the isMirror
     */
    public boolean isIsMirror() {
        return isMirror;
    }
    
    /**
     * Gets the selected cards.
     *
     * @return the selected cards
     */
    public ArrayList<Card> getSelectedCards(){
        ArrayList<Card> cards = new ArrayList<Card>();
        for(Component c : getComponents()){
            if(c instanceof ViewCard){
                if(((ViewCard) c).isRaised()){
                    cards.add(((ViewCard) c).getCard());
                }
            }
        }
        return cards;
    }
    
}

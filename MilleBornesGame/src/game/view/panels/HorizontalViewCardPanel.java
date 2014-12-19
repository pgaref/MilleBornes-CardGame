/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.panels;

import game.CardCollection.AbstractPile;
import game.Cards.Card;
import game.Cards.Distance;
import game.Cards.EmptyCard;
import game.Player.Player;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

// TODO: Auto-generated Javadoc
/**
 * This class represents a Horizontal View of Cards.
 * In our Case we will use two horintal panels for each player since 
 * we want to display 4 differnt Piles!
 * @author Author
 */
public class HorizontalViewCardPanel extends ViewCardPanel {
    
    /** The origin. */
    private Point origin = null;
    
    /**
     * Instantiates a new horizontal view card panel.
     *
     * @param _player the _player
     * @param _isMirror the _is mirror
     */
    public HorizontalViewCardPanel(Player _player,boolean _isMirror){
        super(_player,_isMirror);
        super.setImage_dir("/images/");
        this.setMaximumSize(new Dimension(800, 150));
        this.setPreferredSize(new Dimension(800, 150));
        this.addCards();
    }
    
    /**
     * Instantiates a new horizontal view card panel.
     *
     * @param _player the _player
     * @param _isMirror the _is mirror
     */
    public HorizontalViewCardPanel(Player _player,boolean _isMirror, boolean ExtraCards){
        super(_player,_isMirror);
        super.setImage_dir("/images/");
        this.setMaximumSize(new Dimension(800, 150));
        this.setPreferredSize(new Dimension(800, 150));
        this.addExtraCards();
    }
    
    /**
     * Instantiates a new horizontal view card panel.
     *
     * @param _isMirror the _is mirror
     * @param theSize the the size
     */
    public HorizontalViewCardPanel(boolean _isMirror, Dimension theSize){
        super(_isMirror);
        super.setImage_dir("/images/");
        this.setMaximumSize(theSize);
        this.setPreferredSize(theSize);
        this.addCards();
    }

    
    /**
     * Reset layers.
     */
    public void resetLayers(){
        int i = 0;
        Component[] comps = this.getComponents();
        List<Component> comps_list = Arrays.asList(comps);
        Collections.reverse(comps_list);
        
        for(Component c : comps_list){
            if(c instanceof ViewCard){
                this.setLayer(c, i);
                i++;
            }
        }
    }
    
    /**
     * Sets the origin.
     *
     * @param p the new origin
     */
    public void setOrigin(Point p){
        origin = p;
        this.removeAll();
        super.revalidate();
        super.repaint();
        this.addCards();
    }
    
    /**
     * Reset all cards.
     */
    public void resetAllCards(){
      for(Component c : getComponents()){
        if(c instanceof ViewCard){
            ((ViewCard) c).resetCard();
        }
      }
    }
    
    /**
     * Gets the the selected card.
     *
     * @return the the selected card
     */
    public Card getTheSelectedCard(){
        ArrayList<Card> cards = super.getSelectedCards();
        if(!cards.isEmpty()){
            return cards.get(0);
        }
        return null;
    }
    
    /**
     * Adds the only cards.
     */
    private void addOnlyCards(){
        int i = 0;
        origin = new Point(10, 20);
        ArrayList <Card> table = new ArrayList<Card>();
        for(int j =2; j<15; j++){
            Card tmp = new Distance(75);
            table.add(tmp);
        }
        
        for(Card c : table){
            ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir(),this);
            super.add(card,new Integer(i++));
            origin.x += 25;
        }
    }
    
    /* (non-Javadoc)
     * @see game.view.panels.ViewCardPanel#showCards()
     */
    @Override
    public void showCards(){
        System.out.println("Horizontal showCards");
    }
    
    /**
     * Hide cards.
     */
    public void HideCards(){
        this.removeAll();
        super.revalidate();
        super.repaint();
        this.origin = null;
        int i = 1;
        if(origin == null){ origin = new Point(110, 0);}
        if(super.isIsMirror()) {
            origin.y = 5;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100 , origin.y + 10, 200, 20);
            super.add(name,new Integer(i++));
        }
        else {
            origin.y = 20;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100, origin.y + 100, 200, 20);
            try{
                super.add(name,new Integer(i++)); 
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        for(Card c : super.getPlayer().getPlayersHand()){
        	System.out.println("Repainting Player: "+super.getPlayer().getName()+ " Card: "+ c);
            ViewCard card = new ViewCard(new EmptyCard(),origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
        }
    }
    
    /* (non-Javadoc)
     * @see game.view.panels.ViewCardPanel#changePlayer(game.Player.Player)
     */
    @Override
    public void changePlayer(Player p){
        super.setPlayer(p);
        super.removeAll();
        super.revalidate();
        super.repaint();
        super.name.setText(p.getName());
        origin = new Point(110, 0);
        this.addCards();
    }
    
    /**
     * Adds the cards.
     */
    private void addCards(){
        
    	int i = 1;
        if(origin == null){ 
        	origin = new Point(110, 0);
        }
        
        if(super.isIsMirror()) {
            origin.y = 5;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100 , origin.y + 10, 200, 20);
            super.add(name,new Integer(i++));
        }
        else {
            origin.y = 20;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100, origin.y + 100, 200, 20);
            try{
                super.add(name,new Integer(i++)); 
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        for(Card c : super.getPlayer().getPlayersHand()){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Card: "+ c);
            ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
        }
    }
    
    /**
     * Adds the cards.
     */
    private void addExtraCards(){
        
    	int i = 1;
        if(origin == null){ 
        	origin = new Point(110, 0);
        }
        
        if(super.isIsMirror()) {
            origin.y = 5;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100 , origin.y + 10, 200, 20);
            super.add(name,new Integer(i++));
        }
        else {
            origin.y = 20;
            name.setForeground(Color.red);
            name.setBounds(origin.x - 100, origin.y + 100, 200, 20);
            try{
                super.add(name,new Integer(i++)); 
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        int count = 0;
        for(Card c : super.getPlayer().getSatefy().getCards()){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
            ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
            count ++;
        }
        while (count <= 3){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
            count ++;
        }
        count = 0;
        for(Card c : super.getPlayer().getDistance().getCards()){
        		System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
                ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
                super.add(card,new Integer(i++));
                origin.x += 100;
                count ++;
         }
        if (count < 1){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
        }
        count = 0;
        for(Card c : super.getPlayer().getBattle().getCards()){
            	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
                ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
                super.add(card,new Integer(i++));
                origin.x += 100;
                count ++;
         }
        if (count < 1){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
        }
        count = 0;
        for(Card c : super.getPlayer().getSpeed().getCards()){
            	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
                ViewCard card = new ViewCard(c,origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
                super.add(card,new Integer(i++));
                origin.x += 100;
                count ++;
         }
        if (count < 1){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.isIsMirror() ? Direction.UP : Direction.DOWN,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
        }
        
        
    }

    /**
     * Sets the cards. Only for the Central Panel
     *
     * @param cb the new cards
     */
    public void setCards(AbstractPile cb) {
        System.out.println("called : ");
        super.removeAll();
        super.revalidate();
        super.repaint();
        if(cb == null){ return; }
        int i = 0;
        Point or = new Point(300,25);
        for(Card c : cb.getCards()){
            ViewCard card = new ViewCard(c,or,Direction.DOWN,super.getImage_dir());
            card.setNotMove(true);
            System.out.println(card.getCard().toString());
            super.add(card,new Integer(i++));
            or.x += 25;
        }
        System.out.println("------------------------");
    }
}

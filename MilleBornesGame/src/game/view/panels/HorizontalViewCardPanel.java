/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.panels;

import game.Cards.Card;
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

/**
 * This class represents a Horizontal View of Cards.
 * In our Case we will use two horizontal panels for each player since 
 * we want to display 4 different Piles!
 * @author Author
 */
public class HorizontalViewCardPanel extends ViewCardPanel {
    
    /** The origin. */
    private Point origin = null;
    
    /**
     * Instantiates a new horizontal view card panel.
     *
     * @param _player the _player
     */
    public HorizontalViewCardPanel(Player _player){
        super(_player);
        super.setImage_dir("/images/");
        this.setMaximumSize(new Dimension(800, 150));
        this.setPreferredSize(new Dimension(800, 150));
        this.paintHandCards();
    }
    
    /**
     * Instantiates a new horizontal view card panel.
     *
     * @param _player the _player
     */
    public HorizontalViewCardPanel(Player _player,boolean ExtraCards){
        super(_player);
        super.setImage_dir("/images/");
        this.setMaximumSize(new Dimension(800, 150));
        this.setPreferredSize(new Dimension(800, 150));
        this.paintExtraPileCards();
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
        this.paintHandCards();
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
     * Hide cards.
     */
    public void HideCards(){
        this.removeAll();
        super.revalidate();
        super.repaint();
        this.origin = null;
        int i = 1;
        if(origin == null){ origin = new Point(110, 0);}

		origin.y = 20;
		name.setForeground(Color.red);
		name.setBounds(origin.x - 100, origin.y + 100, 200, 20);
		try {
			super.add(name, new Integer(i++));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

        for(Card c : super.getPlayer().getPlayersHand()){
        	System.out.println("Repainting Player: "+super.getPlayer().getName()+ " Card: "+ c);
            ViewCard card = new ViewCard(new EmptyCard(),origin,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
        }
    }
    
    /**
     * Hide Extra cards!
     */
    public void HideCards(boolean b){
        this.removeAll();
        super.revalidate();
        super.repaint();
        this.origin = null;
        int i = 1;
        if(origin == null){ origin = new Point(110, 0);}

		origin.y = 20;
		name.setForeground(Color.red);
		name.setBounds(origin.x - 100, origin.y + 100, 200, 20);
		try {
			super.add(name, new Integer(i++));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
        
        int count = 0;
        for(Card c : super.getPlayer().getSafety().getCards()){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
            ViewCard card = new ViewCard(c,origin,super.getImage_dir());
            card.setSelectable(true);
            super.add(card,new Integer(i++));
            origin.x += 100;
            count ++;
        }
        while (count <= 3){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
            count ++;
        }
        count = 0;
        if( super.getPlayer().getDistance().getCards().size()>0){
        		Card c =super.getPlayer().getDistance().getLastCard();
        		System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
                ViewCard card = new ViewCard(c,origin,super.getImage_dir());
                card.setSelectable(true);
                super.add(card,new Integer(i++));
                origin.x += 100;
                count ++;
         }
        if (count == 0){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.getImage_dir());
        	card.setSelectable(true);
        	super.add(card,new Integer(i++));
            origin.x += 100;
        }
        count = 0;
        if( super.getPlayer().getBattle().getCards().size()>0){
    		Card c =super.getPlayer().getBattle().getLastCard();
            	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
                ViewCard card = new ViewCard(c,origin,super.getImage_dir());
                card.setSelectable(true);
                super.add(card,new Integer(i++));
                origin.x += 100;
                count ++;
         }
        if (count == 0){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.getImage_dir());
        	card.setSelectable(true);
        	super.add(card,new Integer(i++));
            origin.x += 100;
        }
        count = 0;
        if( super.getPlayer().getSpeed().getCards().size()>0){
    		Card c =super.getPlayer().getSpeed().getLastCard();
            	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
                ViewCard card = new ViewCard(c,origin,super.getImage_dir());
                card.setSelectable(true);
                super.add(card,new Integer(i++));
                origin.x += 100;
                count ++;
         }
        if (count == 0){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.getImage_dir());
        	card.setSelectable(true);
        	super.add(card,new Integer(i++));
            origin.x += 100;
        }
    }
    
    @Override
    public void changePlayer(Player p){
        super.setPlayer(p);
        super.removeAll();
        super.revalidate();
        super.repaint();
        super.name.setText(p.getName());
        origin = new Point(110, 0);
        this.paintHandCards();
    }
    
    /**
     * Paints the Hands - Cards! 
     */
    public void paintHandCards(){
    	super.removeAll();
		super.revalidate();
		super.repaint();
		
    	int i = 1;
    	origin = new Point(110, 0);

		origin.y = 20;
		name.setForeground(Color.red);
		name.setBounds(origin.x - 100, origin.y + 100, 200, 20);
		try {
			super.add(name, new Integer(i++));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
        for(Card c : super.getPlayer().getPlayersHand()){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Card: "+ c);
            ViewCard card = new ViewCard(c,origin,super.getImage_dir());
            super.add(card,new Integer(i++));
            origin.x += 100;
        }
    }
	
    /**
     * Paints the Extra Pile Cards! (Battle, Safety, Speed, Distance)
     */
    public void paintExtraPileCards(){
    	super.removeAll();
		super.revalidate();
		super.repaint();
		
    	int i = 1;
    	origin = new Point(110, 0);
        
		origin.y = 20;
		name.setForeground(Color.red);
		name.setBounds(origin.x - 100, origin.y + 100, 200, 20);
		try {
			super.add(name, new Integer(i++));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		
        int count = 0;
        for(Card c : super.getPlayer().getSafety().getCards()){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
            ViewCard card = new ViewCard(c,origin,super.getImage_dir());
            card.setSelectable(true);
            super.add(card,new Integer(i++));
            origin.x += 100;
            count ++;
        }
        while (count <= 3){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.getImage_dir());
        	card.setSelectable(true);
        	super.add(card,new Integer(i++));
            origin.x += 100;
            count ++;
        }
        count = 0;
        if( super.getPlayer().getDistance().getCards().size()>0){
        		Card c =super.getPlayer().getDistance().getLastCard();
        		System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
                ViewCard card = new ViewCard(c,origin,super.getImage_dir());
                card.setSelectable(true);
                super.add(card,new Integer(i++));
                origin.x += 100;
                count ++;
         }
        if (count == 0){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.getImage_dir());
        	card.setSelectable(true);
        	super.add(card,new Integer(i++));
            origin.x += 100;
        }
        count = 0;
        if( super.getPlayer().getBattle().getCards().size()>0){
    		Card c =super.getPlayer().getBattle().getLastCard();
            	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
                ViewCard card = new ViewCard(c,origin,super.getImage_dir());
                card.setSelectable(true);
                super.add(card,new Integer(i++));
                origin.x += 100;
                count ++;
         }
        if (count == 0){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.getImage_dir());
        	card.setSelectable(true);
        	super.add(card,new Integer(i++));
            origin.x += 100;
        }
        count = 0;
        if( super.getPlayer().getSpeed().getCards().size()>0){
    		Card c =super.getPlayer().getSpeed().getLastCard();
            	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: "+ c);
                ViewCard card = new ViewCard(c,origin,super.getImage_dir());
                card.setSelectable(true);
                super.add(card,new Integer(i++));
                origin.x += 100;
                count ++;
         }
        if (count == 0){
        	System.out.println("Adding Player: "+super.getPlayer().getName()+ " Extra Card: Empty");
        	ViewCard card = new ViewCard(new EmptyCard(),origin,super.getImage_dir());
        	card.setSelectable(true);
        	super.add(card,new Integer(i++));
            origin.x += 100;
        }
        
        
    }
    
    @Override
    public void showCards(){
        System.out.println("Horizontal showCards");
    }

    /**
     * Sets the cards. Used Only for the Central Panel
     *
     * @param cb the new cards
     */
	public void setCard(Card cb) {
		super.removeAll();
		super.revalidate();
		super.repaint();
		if (cb == null) {
			return;
		}
		int i = 0;
		Point or = new Point(300, 0);
		ViewCard card = new ViewCard(new EmptyCard(), or,
				super.getImage_dir());
		card.setSelectable(true);
		super.add(card, new Integer(i++));
		or.x += 25;

	}


}

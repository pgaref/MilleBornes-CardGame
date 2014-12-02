/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.panels;

import game.Cards.Card;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * This class the View of a Single Card.
 * Implemented a raised functionality and load image graphics
 * @author Author
 */
public class ViewCard extends JLabel implements MouseListener{
    
    /** The card_image. */
    private ImageIcon card_image;
    
    /** The card. */
    private Card  card;
    
    /** The raised. */
    private boolean raised;
    
    /** The size. */
    private Dimension size;
    
    /** The origin. */
    private Point origin;
    
    /** The direction. */
    private Direction direction;
    
    /** The not move. */
    private boolean notMove;
    
    /** The parent. */
    private HorizontalViewCardPanel parent = null;
    
    /**
     * Instantiates a new view card.
     *
     * @param _card the _card
     * @param _origin the _origin
     * @param _direction the _direction
     * @param imagepath the imagepath
     */
    public ViewCard(Card _card,Point _origin, Direction _direction,String imagepath){
        this.card = _card;
        this.notMove = false;
        this.direction = _direction;
        this.raised = false;
        this.origin = new Point(_origin.x , _origin.y);
        this.card_image = new ImageIcon(getClass().getResource(_card.getImagePath()));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, false));
        this.size = new Dimension((getCard_image().getImage().getWidth(null) * 8) / 10, 
                                   (getCard_image().getImage().getHeight(null) * 8) /10);
        this.setBounds(this.origin.x, this.origin.y, this.size.width, this.size.height);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setVisible(true);
        this.addMouseListener(this);
    }
    
    /**
     * Instantiates a new view card.
     *
     * @param _card the _card
     * @param _origin the _origin
     * @param _direction the _direction
     * @param imagepath the imagepath
     * @param _parent the _parent
     */
    public ViewCard(Card _card,Point _origin, Direction _direction,String imagepath, HorizontalViewCardPanel _parent){
        this.card = _card;
        this.notMove = true;
        parent = _parent;
        this.direction = _direction;
        this.raised = false;
        this.origin = new Point(_origin.x , _origin.y);
        this.card_image = new ImageIcon(getClass().getResource(imagepath + _card.toString()));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, false));
        this.size = new Dimension((getCard_image().getImage().getWidth(null) * 8) / 10, 
                                   (getCard_image().getImage().getHeight(null) * 8) /10);
        this.setBounds(this.origin.x, this.origin.y, this.size.width, this.size.height);
        this.setVerticalAlignment(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
        this.setVisible(true);
        this.addMouseListener(this);
    }
    
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(getCard_image().getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
    }

    /**
     * Gets the card.
     *
     * @return the card
     */
    public Card getCard() {
        return card;
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(MouseEvent e) {}

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if(this.isNotMove()){
            if(this.parent != null){
                this.parent.resetAllCards();
                moveCard(0);             
            }
            return;
        }
        moveCard(0);

    }

    /**
     * Reset card.
     */
    public void resetCard(){
        this.setBounds(origin.x , origin.y, size.width, size.height);
        raised = false;
    }
    
    /**
     * Move card.
     *
     * @param points the points
     */
    private void moveCard(int points){
        if(isRaised()){
            this.setBounds(origin.x , origin.y, size.width, size.height);
            raised = false;
        }
        else{
            this.setBounds(origin.x + this.direction.getPoint().x, origin.y + this.direction.getPoint().y + points, size.width, size.height);
            raised = true;
        }
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(MouseEvent e){}

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(MouseEvent e) {}

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(MouseEvent e) {}

    /**
     * Checks if is not move.
     *
     * @return the notMove
     */
    public boolean isNotMove() {
        return notMove;
    }

    /**
     * Sets the not move.
     *
     * @param notMove the notMove to set
     */
    public void setNotMove(boolean notMove) {
        this.notMove = notMove;
    }

    /**
     * Gets the card_image.
     *
     * @return the card_image
     */
    private ImageIcon getCard_image() {
        return card_image;
    }

    /**
     * Sets the card_image.
     *
     * @param card_image the card_image to set
     */
    public void setCard_image(ImageIcon card_image) {
        this.card_image = card_image;
    }

    /**
     * Checks if is raised.
     *
     * @return the raised
     */
    public boolean isRaised() {
        return raised;
    }
    

}

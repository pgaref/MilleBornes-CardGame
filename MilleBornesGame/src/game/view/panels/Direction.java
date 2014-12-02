/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.panels;

import java.awt.Point;

// TODO: Auto-generated Javadoc
/**
 * This class represents the Direction of the Cards in the VIEW
 * Used to place the cards in the correct space.
 *
 * @author Author
 */
public enum Direction {
    
    /** The up. */
    UP,
/** The down. */
DOWN,
/** The left. */
LEFT,
/** The right. */
RIGHT;
    
    /**
     * Gets the point.
     *
     * @return the point
     */
    public Point getPoint(){
        switch(this){
            case UP:
                return new Point(0,15);
            case DOWN:
                return new Point(0,-15);
            case LEFT:
                return new Point(20,0);
            case RIGHT:
                return new Point(-20,0);
            default:
                return new Point(0,0);
        }
    }
}

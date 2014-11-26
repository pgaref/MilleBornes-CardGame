/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.controller;

import game.master.GameCore;
import javax.swing.JFrame;

/**
 *  This class is responsible to connect the Model with the View Part.
 *  Meaning that it is the connecting point between the Game algorithm and the GUI.
 * 
 * @author Author
 */
public class GameController {

    
    JFrame view;
    GameCore model;
    
    public GameController(JFrame f, GameCore m){
        this.model = m;
        this.view = f;
    }
    
    
    
}

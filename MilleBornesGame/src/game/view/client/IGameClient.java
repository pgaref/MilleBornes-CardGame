/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.client;

import game.Player.Player;

/**
 * The Interface IGameClient.
 */
public interface IGameClient {
    
    /**
     * Show cards window.
     *
     * @return the player
     */
    public Player showCardsWindow();
    
    /**
     * Skip player.
     */
    public void skipPlayer();
    
    /**
     * Change player.
     */
    public void changePlayer();
    
    /**
     * New round.
     */
    public void newRound();
    
    /**
     * Show winner panel.
     *
     * @param _winner the _winner
     */
    public void showWinnerPanel(String _winner);
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.client;

import game.Player.Player;

public interface IGameClient {
    
    public Player showCardsWindow();
    public void skipPlayer();
    public void changePlayer();
    public void newRound();
    public void showWinnerPanel(String _winner);
    
}
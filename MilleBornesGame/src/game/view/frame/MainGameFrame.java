/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.frame;

import game.Player.Player;
import game.master.GameMaster;
import game.view.client.IGameClient;
import game.view.panels.GameInfoPanel;
import game.view.panels.InitPlayers;
import game.view.panels.PlayersPanel;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The Class MainGameFrame.
 *
 * @author Author
 */
public class MainGameFrame extends javax.swing.JFrame implements IGameClient{

    /** The game. */
    private final GameMaster game;
    
    /** The players space. */
    private final PlayersPanel playersSpace; 
    
    /** The gameinfo. */
    private final GameInfoPanel gameinfo;
   
    private String p1 ,p2;
    
    /**
     * Creates new form MainGameFrame.
     */
   
   
    public MainGameFrame() {
        super("MilleBornes Game");
        InitPlayers players = new InitPlayers(null,true);
        Object [] playerNames =  players.getPlayers().toArray();
        this.p1 = String.valueOf(playerNames[0]);
        this.p2 = String.valueOf(playerNames[1]);
        this.game = new GameMaster(this, p1, p2);
        
//        p1 = "a";
//        p2 = "b";
//        this.game = new GameMaster(this, p1, p2);
        
        this.playersSpace = new PlayersPanel(game);
        this.gameinfo = new GameInfoPanel(game,playersSpace);
        this.playersSpace.setOpaque(true); 
        this.add(playersSpace,BorderLayout.CENTER);
        this.add(gameinfo, BorderLayout.EAST);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 800);
        
    }

    
    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGameFrame().setVisible(true);
            }
        });
    }

	@Override
	public void showWinnerPanel(String _winner) {
		
		int n = JOptionPane.showConfirmDialog(this,
				"Would you like to play again?", "Game Finished! Winner is: "+ _winner,
				JOptionPane.YES_NO_OPTION);

		if (n == JOptionPane.YES_OPTION) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			
		} else if (n == JOptionPane.NO_OPTION) {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}

	}

    @Override
    public void changePlayer() {
    	this.gameinfo.changePlayer();
    }


    
}

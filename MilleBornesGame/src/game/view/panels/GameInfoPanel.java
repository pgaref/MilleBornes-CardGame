/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game.view.panels;

import game.CardCollection.NotSupportedOperationException;
import game.Cards.Card;
import game.Cards.Safety;
import game.master.GameMaster;
import game.master.GameState;

import javax.swing.JTextField;

/**
 * This class represents the Game Info Panel
 * This panel is attached to the right of the Jframe and displays information about the game.
 *
 * @author Author
 */
public class GameInfoPanel extends javax.swing.JPanel {

    /** Creates new form test. */
    private GameMaster game;
    
    /** The players. */
    private PlayersPanel players;
    
 // Variables declaration 
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton passButton;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel playername;
    private javax.swing.JTextField player1points;
    private javax.swing.JTextField player2points;
    private javax.swing.JButton throwCards;
    
    
    /**
     * Instantiates a new game info panel.
     *
     * @param _game the _game
     * @param _players the _players
     */
    public GameInfoPanel(GameMaster _game , PlayersPanel _players) {
        initComponents();
        game = _game;
        players = _players;
        
        player1points.setText("0");
        player2points.setText("0");
        player1points.setHorizontalAlignment(JTextField.RIGHT);
        player2points.setHorizontalAlignment(JTextField.RIGHT);        
    }
    
    /**
     * Change player.
     */
    public void changePlayer(){
        playername.setText(game.getCurrentPlayer().getName());    
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        player1points = new javax.swing.JTextField();
        player2points = new javax.swing.JTextField();
        
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        playButton = new javax.swing.JButton();
        passButton = new javax.swing.JButton();
        throwCards = new javax.swing.JButton();
        playername = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(183, 416));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel9.setText("Miles");

        player2points.setEditable(false);
        player2points.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(player2points, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(player2points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Player 2");

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel4.setText("Miles");

        player1points.setEditable(false);
        player1points.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(player1points)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(player1points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Player 1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Points");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        playButton.setText("Play");
        //playButton.setEnabled(false);
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });
        
        passButton.setText("Pass");
        passButton.setEnabled(false);
        /*passButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passButtonActionPerformed(evt);
            }
        });*/

        throwCards.setText("Dismiss Card");
        throwCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                throwCardsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(throwCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playButton)
                    .addComponent(passButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(throwCards)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        playername.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        playername.setText("playername");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playername, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }

    /**
     * Play button action performed.
     *
     * @param evt the evt
     */
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
       
    	if(!game.getCurrentPlayer().hasDrawnCard()){
    		System.out.println("Please draw a card first!");
    		return;
    	}	
    	
    	Card card = getPlayers().getSelectedCard();
        System.out.println("Got card: "+ card);
        
        try{
        	
        	if(game.playerSubmitsCard(card)){
        		
        		//if player throws a Safety Card, player plays again
        		if(!(card instanceof Safety) )
        			getPlayers().changePlayerTurn();
        		else{
        			game.getCurrentPlayer().changeDrawnCard(false);
        			players.currPlayerDraw();
        		}
        		//update Panel Stats anyway
        		this.updatePlayerPoints();
        		
        	}
        	
        }catch(NotSupportedOperationException ex){
        	System.err.println("Cannot Throw card: "+ card);	
        	ex.printStackTrace();
        }
        
    }

    /**
     * Throw cards action performed.
     *
     * @param evt the evt
     */
    private void throwCardsActionPerformed(java.awt.event.ActionEvent evt) {
       
    	Card card = getPlayers().getSelectedCard();
        System.out.println("Got card: "+ card);   
       
        if(game.playerDiscardsCard(card))
        	getPlayers().changePlayerTurn();
    }
    
    
    
    private void updatePlayerPoints(){
    	
    	this.player1points.setText(this.game.getFirstPlayer().getMilesRun()+"");
    	this.player2points.setText(this.game.getSecondPlayer().getMilesRun()+"");
    	
    	//Winner case, update game state and show final Jpanel!
    	if( this.game.getFirstPlayer().getMilesRun() == 1000 ){
    		this.game.setState(GameState.FINISHED);
    		game.getGameClient().showWinnerPanel(this.game.getFirstPlayer().getName());
    	}
    	else if( this.game.getSecondPlayer().getMilesRun() == 1000 ){
    		this.game.setState(GameState.FINISHED);
    		game.getGameClient().showWinnerPanel(this.game.getSecondPlayer().getName());
    	}
    	
    	//Out of cards Case! The first player who runs out of card wins!
    	if(this.game.getFirstPlayer().getHand().size() == 0){
    		this.game.setState(GameState.FINISHED);
    		game.getGameClient().showWinnerPanel(this.game.getFirstPlayer().getName());
    	}
    	else if(this.game.getSecondPlayer().getHand().size() == 0){
    		this.game.setState(GameState.FINISHED);
    		game.getGameClient().showWinnerPanel(this.game.getSecondPlayer().getName());
    	}
    	
    }



    /**
     * Gets the players.
     *
     * @return the players
     */
    public PlayersPanel getPlayers() {
        return players;
    }

    /**
     * Sets the players.
     *
     * @param players the players to set
     */
    public void setPlayers(PlayersPanel players) {
        this.players = players;
    }
}

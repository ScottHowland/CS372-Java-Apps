/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midterm;

import java.util.ArrayList;
import java.io.*;
import java.util.Random;
import java.lang.String;

/**
 * The DiceFrame is the GUI used to handle player logins, managing player data
 * to and from files, as well as handling the betting process and updating the curent
 * player's wallet
 * @author showland17
 */
public class DiceFrame extends javax.swing.JFrame {

    ArrayList<Player> players = new ArrayList();
    ArrayList<String> playerNames = new ArrayList();
    String nameFileName = "C:\\Users\\showland17\\Documents\\GitHub\\CS372-Java-Apps\\MidTerm\\Names.txt";
    String walletFileName = "C:\\Users\\showland17\\Documents\\GitHub\\CS372-Java-Apps\\MidTerm\\Wallets.txt";
    Player currentPlayer;
    File nameBase = new File(nameFileName);
    File walletBase = new File(walletFileName);
    FileIO io = new FileIO();
    int betStatus;
    Random rand = new Random();
    /**
     * Creates new form DiceFrame
     */
    public DiceFrame() {
        initComponents();
        betStatus = -1;
        if (nameBase.exists()) {
            LoadPlayers();
        }
    }
    
    /**
     * Populates the players ArrayList with all usernames currently on file
     */
    public void LoadPlayers() {
        io.ReadPlayers(players, nameBase);
        
        for (int i=0; i < players.size(); i++) {
            Player p = players.get(i);
            playerNames.add(p.Name());
            io.ReadWallet(p, walletBase, i);
        }
    }
    
    /**
     * Generates the result of an Over-Under round
     * @return The die result
     */
    public int RollDice(int whichDie) {
        int result = rand.nextInt(6) + 1;
        return result;        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BetGroup = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        fldLogin = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnUnder = new javax.swing.JRadioButton();
        btnSeven = new javax.swing.JRadioButton();
        btnOver = new javax.swing.JRadioButton();
        lblPrompt = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        lblWallet = new javax.swing.JLabel();
        fldBet = new javax.swing.JTextField();
        lblBet = new javax.swing.JLabel();

        BetGroup.add(btnUnder);
        BetGroup.add(btnSeven);
        BetGroup.add(btnOver);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel1.setText("Underground Under-Over Ring");

        lblUsername.setText("Username");

        fldLogin.setText("ex: FluffyBunny19");

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnUnder.setText("Under 7");
        btnUnder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnderActionPerformed(evt);
            }
        });

        btnSeven.setText("7");
        btnSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSevenActionPerformed(evt);
            }
        });

        btnOver.setText("Over 7");
        btnOver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOverActionPerformed(evt);
            }
        });

        lblPrompt.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblPrompt.setText("Please Login to Play");

        btnPlay.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        btnPlay.setText("Play!");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        lblWallet.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblWallet.setText("Cash On Hand: 0");

        fldBet.setText("Bet Amount");
        fldBet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldBetActionPerformed(evt);
            }
        });

        lblBet.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        lblBet.setText("Place Your Bets!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(0, 179, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnPlay))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(lblWallet))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btnLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(lblUsername)
                        .addGap(18, 18, 18)
                        .addComponent(fldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPrompt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnUnder)
                                    .addGap(28, 28, 28)
                                    .addComponent(btnSeven)
                                    .addGap(31, 31, 31)
                                    .addComponent(btnOver))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblBet)
                                    .addGap(18, 18, 18)
                                    .addComponent(fldBet, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblPrompt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addGap(25, 25, 25)
                .addComponent(lblWallet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBet)
                    .addComponent(fldBet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUnder)
                    .addComponent(btnSeven)
                    .addComponent(btnOver))
                .addGap(22, 22, 22)
                .addComponent(btnPlay)
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSevenActionPerformed
        betStatus = 1;
    }//GEN-LAST:event_btnSevenActionPerformed

    private void btnUnderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnderActionPerformed
        betStatus = 0;
    }//GEN-LAST:event_btnUnderActionPerformed

    private void btnOverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOverActionPerformed
        betStatus = 2;
    }//GEN-LAST:event_btnOverActionPerformed

    /**
     * Calculates the result of the Over-Under round, then rewards the player accordingly
     * based on their bet selection and cash betted
     * @param evt 
     */
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        int die1 = RollDice(1);
        int die2 = RollDice(2);
        int result = die1 + die2;
        int betAmount;
        
        try {
            betAmount = Integer.parseInt(fldBet.getText(), 10);
            
            if (betAmount > currentPlayer.Wallet())
                throw new Exception();
            
            if (betStatus == 0) {
                if (result < 7)
                    currentPlayer.WalletGain(betAmount);
                else
                    currentPlayer.WalletLoss(betAmount);
            }                        
        
            else if (betStatus == 1) {
                if (result == 7)
                    currentPlayer.WalletGain(4 * betAmount);
                else
                    currentPlayer.WalletLoss(betAmount);
            }
        
            else if (betStatus == 2) {
                if (result > 7)
                    currentPlayer.WalletGain(betAmount);
                else
                    currentPlayer.WalletLoss(betAmount);
            }
            
            else
                throw new Exception();
        
        String lblText = "Cash On Hand: " + currentPlayer.Wallet().toString();
        lblWallet.setText(lblText);
        }
        
        catch (Exception ex) {
            System.out.println("Invalid Bet");
        }
        
    }//GEN-LAST:event_btnPlayActionPerformed

    private void fldBetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldBetActionPerformed
        
    }//GEN-LAST:event_fldBetActionPerformed

    /**
     * Uses the text entered in the login field to create a new user as appropriate,
     * and then update the in-game display with their wallet contents
     * @param evt 
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String login = fldLogin.getText();
        
        //If this username doesn't have a corresponding player, make one
        if (!nameBase.exists() || !playerNames.contains(login)) {
            io.WritePlayer(login, nameBase);
            Player newKid = new Player(login);
            players.add(newKid);
        }
        //Check to see which player the login is identical to, then update the
        //game with that player's information
        for (Player p : players) {
            if (login.equals(p.Name())) {
                currentPlayer = p;
                String lblText = "Cash On Hand: " + p.Wallet().toString();
                lblWallet.setText(lblText);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * Writes all the wallet values to file as the window closes. We need not 
     * do this with players, since they are added to file as they are created
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        io.WriteWallets(players, walletBase);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BetGroup;
    private javax.swing.JButton btnLogin;
    private javax.swing.JRadioButton btnOver;
    private javax.swing.JButton btnPlay;
    private javax.swing.JRadioButton btnSeven;
    private javax.swing.JRadioButton btnUnder;
    private javax.swing.JTextField fldBet;
    private javax.swing.JTextField fldLogin;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBet;
    private javax.swing.JLabel lblPrompt;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblWallet;
    // End of variables declaration//GEN-END:variables
}

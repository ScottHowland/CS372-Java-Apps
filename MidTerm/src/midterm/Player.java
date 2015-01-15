/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midterm;

/**
 * A Player has a username and a wallet representing their current funds. The 
 * class has methods to alter the amount of funds the user has, as well as providing
 * access to member variables
 * @author showland17
 */
public class Player {
    private String name;
    private Integer wallet;
    
    /**
     * Initializes the username and wallet size
     * @param userName 
     */
    public Player (String userName) {
        name = userName;
        wallet = 500;
    }
    
    /**
     * Represents a deduction of a certain amount from the user's funds
     * @param deduction 
     */
    public void WalletLoss(Integer deduction) {
        wallet -= deduction;
    }
    
    /**
     * Represents a deposit of a certain amount of funds into the user's finances
     * @param deposit 
     */
    public void WalletGain (int deposit) {
        wallet += deposit;
    }
    
    /**
     * Alters the state of the wallet to a specified value, rather than in increments.
     * Useful for setting wallets upon upload from file
     * @param amount 
     */
    public void SetWallet (int amount) {
        wallet = amount;
    }
    
    /**
     * Name accessor
     * @return 
     */
    public String Name() {
        return name;
    }
    
    /**
     * Wallet accessor
     * @return 
     */
    public Integer Wallet() {
        return wallet;
    }
}

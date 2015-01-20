/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package midterm;

import java.io.*;
import java.util.ArrayList;
/**
 * FileIO allows reading and writing of data to and from a given file
 * @author showland17
 */
public class FileIO {        
    
    /**
     * Write a given player to the passed-in file
     * @param playerName
     * @param destination 
     */
    public void WritePlayer(String playerName, File destination) {
         try {
            BufferedWriter wrtr = new BufferedWriter(new FileWriter (destination,true));  
            String line = playerName;
                wrtr.write(line);
                wrtr.newLine();
                wrtr.close();
        }
        
        catch (IOException ex) {
           System.out.println("An error writing to file has occurred.\n");
        }
    }
    
    /**
     * Will write the wallet values for each Player to file
     * @param wallets
     * @param destination 
     */
    public void WriteWallets(ArrayList<Player> players, File destination) {
         try {
            BufferedWriter wrtr = new BufferedWriter(new FileWriter (destination,false));  
            for (Player p : players) {
                wrtr.write(p.Wallet().toString());
                wrtr.newLine();
            }
            wrtr.close();
        }
        
        catch (IOException ex) {
           System.out.println("An error writing to file has occurred.\n");
        }
    }   
    
    /**
     * Reads all the player names from a file
     * @param players
     * @param manuscript 
     */
    public void ReadPlayers(ArrayList<Player> players, File manuscript) {
        try {
            BufferedReader rdr = new BufferedReader (new FileReader(manuscript));
            String line;
            while ((line = rdr.readLine()) != null)
                players.add(new Player(line));
            rdr.close();
        }
        
        catch (IOException ex) {
            System.out.println("An error reading from file has occurred.\n");
        }
    }
    
    /**
     * Reads the wallet value of a specific user from file
     * @param player
     * @param manuscript
     * @param targetLine 
     */
    public void ReadWallet(Player player, File manuscript, int targetLine) {
        try {
            int i=0;
            BufferedReader rdr = new BufferedReader (new FileReader(manuscript));
            String line;
            while ((line = rdr.readLine()) != null) {
                if (i == targetLine) {
                    Integer purse = Integer.decode(line);
                    player.SetWallet(purse);
                }
            }       
        }
        
        catch (IOException ex) {
            System.out.println("An error reading from file has occurred\n");
        }
    }
}
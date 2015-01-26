/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalsandbox;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A ScoreIO is responsible for reading and writing a record of scores achieved 
 * by the local users of the application
 * @author showland17
 */
public class ScoreIO {
    /**
     * Appends an integer score to a given file
     * @param destination The file the score is to be added to
     * @param score The score value to be appended
     */
    public void writeScore (File destination, Integer score) {
        try {
            BufferedWriter wrtr = new BufferedWriter (new FileWriter (destination,true));
            String line = score.toString();
            wrtr.write(line);
            wrtr.newLine();
            wrtr.close();
        }
        catch (IOException ex) {
            Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Reads each line of the given file, attempting to convert each string
     * found to an integer, then adding it to the ArrayList of scores to be 
     * used by the application
     * @param destination The file whose contents are to be read
     * @param scores The ArrayList the score values are to be added to
     */
    public void readScores (File destination, ArrayList<Integer> scores) {
        try {
            BufferedReader rdr = new BufferedReader (new FileReader (destination));
            String line = "";
            
            while ((line = rdr.readLine()) != null) {
                try {
                    Integer score = Integer.parseInt(line);
                    scores.add(score);
                }
                catch (NumberFormatException ex) {
                    Logger.getLogger(ScoreIO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            rdr.close();
        }
        catch (IOException ex) {
            Logger.getLogger(ScoreIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
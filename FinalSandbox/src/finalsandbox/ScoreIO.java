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
    public void writeScores (File destination, Integer score) {
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
}

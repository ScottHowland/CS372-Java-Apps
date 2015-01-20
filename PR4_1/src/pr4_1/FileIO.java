/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr4_1;

import java.io.*;
/**
 *
 * @author Scott
 */
public class FileIO {
    String filePath;
    
    public FileIO(String filePath) {
        this.filePath = filePath;
    }
    
    public void writeReviews(String reviewBlock) {
        try {
            BufferedWriter wrtr = new BufferedWriter (new FileWriter (filePath, false));
            wrtr.write(reviewBlock);
            wrtr.close();
        }
        
        catch (IOException ex) {
            System.out.println("Error: Failed to write to file.");
        }
    }
    
    public String readReviews() {
        String reviewBlock = "", line;
        
        try {
            BufferedReader rdr = new BufferedReader (new FileReader (filePath));
            
            while ((line = rdr.readLine()) != null) {
                reviewBlock += line;
            }
        }
        
        catch (IOException ex) {
            System.out.println("Error: Failed to read from file");
        }
        
        return reviewBlock;
    }
}

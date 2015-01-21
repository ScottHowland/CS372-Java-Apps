/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr4_1;

import java.util.ArrayList;
import java.io.*;
/**
 * A <code>FileIO</code> stores a string value representing the filepath of the
 * file it will interact with, as well as methods to write and read reviews 
 * specific to the restaurant reviewer application
 * @author Scott
 */
public class FileIO {
    private final String filePath;
    
    /**
     * Establishes the file path to be used by the IO object
     * @param filePath 
     */
    public FileIO(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * Writes the data fields associated with a <code>Review</code> in a format
     * conductive to reading the fields back into the application later
     * @param reviews The ArrayList of <code>Reviews</code> used by the application
     */
    public void writeReviews(ArrayList<Review> reviews) {
        try {
            BufferedWriter wrtr = new BufferedWriter (new FileWriter (filePath, false));
            
            for (Review r : reviews) {
                wrtr.write(r.establishment());
                wrtr.newLine();
                wrtr.newLine();
                wrtr.write(r.address());
                wrtr.newLine();
                wrtr.newLine();
                wrtr.write(r.rating().toString());
                wrtr.newLine();
                wrtr.newLine();
                wrtr.write(r.notes());
                wrtr.newLine();
                wrtr.newLine();
            }
            wrtr.close();
        }
        
        catch (IOException ex) {
            System.out.println("Error: Failed to write to file.");
        }
    }
    
    /**
     * Reads the text file containing the reviews used by the application
     * @param reviews
     * @return 
     */
    public String readReviews(ArrayList<Review> reviews) {
        String reviewBlock = "", line;
        
        try {
            BufferedReader rdr = new BufferedReader (new FileReader (filePath));
            String name="", location="", notes="";
            Integer rating = -1;
            int fieldCounter = 0;
            
            while ((line = rdr.readLine()) != null) {
                reviewBlock += line;
                
                if (line.equals("")) {
                    fieldCounter++;
                    continue;
                }
                    
                
                if (fieldCounter % 4 == 0) {
                    name += reviewBlock;
                    reviewBlock = "";
                }
                    
                else if (fieldCounter % 4 == 1) {
                    location += reviewBlock;
                    reviewBlock = "";
                }
                    
                else if (fieldCounter % 4 == 2) {
                    try {
                        rating = Integer.parseInt(reviewBlock);
                        reviewBlock = "";
                    }
                        
                    catch (NumberFormatException ex) {
                        System.out.println("Error parsing integer value");
                        }
                }
                    
                else if (fieldCounter % 4 == 3) {
                    notes += reviewBlock;
                    reviewBlock = "";
                    reviews.add(new Review (name, location, notes, rating));
                    name = "";
                    location = "";
                    notes = "";
                    rating = -1;
                }
            }
            rdr.close();
        }
        
        catch (IOException ex) {
            System.out.println("Error: Failed to read from file");
        }
        return reviewBlock;
    }
}

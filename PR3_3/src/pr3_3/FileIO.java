/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_3;

import java.io.*;
import java.util.ArrayList;
/**
 * FileIO allows reading and writing of data to and from a given file
 * @author showland17
 */
public class FileIO {
    private String fileName;
    
    /**
     * Sets the path of the file that the FileIO will be interacting with
     * @param fileName The file's path
     */
    public FileIO(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * Writes any number of strings to the FileIO's file, each on a new line
     * @param strings 
     */
    public void Write(String ... strings) {
        File f = new File(fileName);
        try {
            BufferedWriter wrtr = new BufferedWriter(new FileWriter (f,true));
            for (String s: strings) {
                String line = s;
                wrtr.write(line);
                wrtr.newLine();
            }
            wrtr.close();
        }
        
        catch (IOException ex) {
           System.out.println("An error writing to file has occurred.\n");
        }
    }
    
    /**
     * Reads every line of the FileIO's file. Out of every 3 lines, the first is
     * assigned to an Appointment name, the second to a location, and the third
     * to a date. After every 3 lines, these values are used to construct a new
     * Appointment for use in the application proper
     * @param strings
     * @return 
     */
    public String ReadAll(ArrayList<Appointment> strings) {
        File f = new File("C:\\Users\\showland17\\Documents\\GitHub\\CS372-Java-Apps\\PR3_3\\dates\\dates.txt");
        String total = "";
        int counter = 1;
        String title = "", location = "", date = "";
        
        try {
            BufferedReader rdr = new BufferedReader (new FileReader(f));
            String line;
            
            while ((line = rdr.readLine()) != null) {
                if (counter % 3 == 1) {
                    title = line;
                    ++counter;
                }
                else if (counter % 3 == 2) {
                        location = line;
                        ++counter;
                }
                else if (counter % 3 == 0) {
                    date = line;
                    strings.add(new Appointment (title, location, date));
                    counter = 1;
                }
            }
            rdr.close();
        }
        
        catch (IOException ex) {
            System.out.println("An error reading from file has occurred.\n");
        }
        
        return total;
    }
}

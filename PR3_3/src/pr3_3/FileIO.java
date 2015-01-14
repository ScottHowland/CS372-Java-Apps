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
    
    public FileIO(String fileName) {
        this.fileName = fileName;
    }
    
    public void Write(String toWrite) {
        File f = new File(fileName);
        try {
            BufferedWriter wrtr = new BufferedWriter(new FileWriter (f,true));  
            String line = toWrite;
                wrtr.write(line);
                wrtr.newLine();
                wrtr.close();
        }
        
        catch (IOException ex) {
           System.out.println("An error writing to file has occurred.\n");
        }
    }
    
    public String ReadAll(ArrayList<String> strings) {
        File f = new File("C:\\Users\\showland17\\Documents\\GitHub\\CS372-Java-Apps\\PR3_3\\dates\\dates.txt");
        String total = "";
        try {
            BufferedReader rdr = new BufferedReader (new FileReader(f));
            String line;
            while ((line = rdr.readLine()) != null)
                strings.add(line);
            rdr.close();
        }
        
        catch (IOException ex) {
            System.out.println("An error reading from file has occurred.\n");
        }
        
        return total;
    }
}

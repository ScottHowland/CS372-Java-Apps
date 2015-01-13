/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_1;

/**
 *
 * @author showland17
 */
public class PR3_1 {

    /**
     * Use an IntGetter to store ten integers from user input, then print them
     * to the console
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntGetter getter = new IntGetter();
        
        try {
            getter.getValues(10);
        }        
        catch (Exception ex) {
            System.out.printf("An error occurred.\n");
            ex.getMessage();
        }
        
        getter.printCollection();
    }    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * An <code>IntGetter</code> has a collection of user-specified integer values, 
 * as well as the ability to add X elements to the collection, handling invalid 
 * user input
 * @author showland17
 */
public class IntGetter {
    /**
     * An <code>ArrayList</code> of integers used to store user int collections 
     * of any size
     */
    private ArrayList<Integer> valueCollection = new ArrayList ();
    
    /**
     * Collects a given number of integers from user input to be stored in the
     * <code>valueCollection</code>. All non-integer values will be discarded,
     * and the user asked to re-enter that value
     * @param collectionSize The number of elements to be gathered
     */
    public void getValues (int collectionSize)
                throws IllegalArgumentException, InputMismatchException {
        
        if (collectionSize <= 1) {
            throw new IllegalArgumentException ();
        }
             
        int currElement = 1;
        Scanner inptListener = new Scanner(System.in);
        
        while (currElement <= collectionSize) {
            try {
                System.out.printf("New integer %d: ", currElement);
                            
                if (!inptListener.hasNextInt()) {
                    throw new InputMismatchException();
                }
                
                valueCollection.add(inptListener.nextInt());
                currElement++;
            }
            
            catch (InputMismatchException ex) {
                System.out.printf("That wasn't an integer.\n");
                inptListener.nextLine();
            }
        }
    }
    
    /**
     * Prints all of the elements of the valueCollection to the console
     */
    public void printCollection () {
        System.out.printf("Collection Contents: ");
        
        for (int i : valueCollection) {
            System.out.printf("%d ", i);
        }
    }
}

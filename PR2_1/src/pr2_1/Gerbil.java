/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_1;

/**
 * A Gerbil is responsible for knowing its ID number as well as hopping behavior
 * @author showland17
 */
public class Gerbil {
    /**
     * Will become the ID number of the next Gerbil to be created
     */
    private static int current_ID_number = 0;
    
    /** 
     * Will be assigned based on the <code>current_ID_number</code> shared by all Gerbils 
     */
    private int this_ID_number;
    
    /** 
     * Sets this Gerbil's ID number based on the universal Gerbil ID number counter
     */
    public Gerbil() {
        this_ID_number = Gerbil.current_ID_number;
        ++Gerbil.current_ID_number;
    }
    
    /** 
     * Prints the ID number of the Gerbil and that it is currently hopping
     */
    public void Hop() {
        System.out.printf("%d is hopping.\n", this_ID_number);
    }
}

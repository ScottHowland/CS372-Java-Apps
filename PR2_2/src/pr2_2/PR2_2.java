/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_2;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Displays the ID numbers and hopping status of an ArrayList of Gerbils using Iterators
 * @author showland17
 */
public class PR2_2 {

    /**
     * Populates an ArrayList with 10 Gerbils, then calls their <code>Hop</code> methods
     * using an Iterator
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList gerbils = new ArrayList();
        
        for (int i=0; i < 10; ++i) {
            gerbils.add(new Gerbil());
        }
        
        Iterator gerbiliter = gerbils.iterator();
        
        /** 
         * Until the end of the array is reached, call the <code>Hop</code> method
         * of the next Gerbil
         */
        while (gerbiliter.hasNext()) {
            ((Gerbil)gerbiliter.next()).Hop();
        }
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_3;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A GerbilHashMap can execute a <code>RollCall</code>, where the hash key of 
 * each Gerbil is printed to the console and a <code>Hop</code> command is issued
 * @author showland17
 */
public class GerbilHashMap {
    HashMap<Integer, Gerbil> gerbilHash = new HashMap();
    
    public GerbilHashMap(HashMap<Integer, Gerbil> roster) {
        this.gerbilHash = roster;
    }
    
     /**
         * Print the hash key of each Gerbil after searching for its ID number,
         * then tell it to <code>Hop</code>
         */
    public void RollCall(Iterator<Gerbil> gerbiliter) {
        while (gerbiliter.hasNext()) {
            Gerbil temp_gerbil = (Gerbil)gerbilHash.get(gerbiliter.next());
           
            System.out.printf("Gerbil number %d has a key of %d\n" , temp_gerbil.GetID(), temp_gerbil.hashCode());
            temp_gerbil.Hop();
        }
    }
}

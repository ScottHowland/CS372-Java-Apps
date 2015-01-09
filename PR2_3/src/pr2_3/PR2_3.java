/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_3;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Fills a HashMap with ID numbers and Gerbils, then prints the hash keys and tells
 * the Gerbils to <code>Hop</code>
 * @author showland17
 */
public class PR2_3 {

    /**
     * Populates a HashMap with 10 ID numbers and Gerbils, then searches through 
     * the map, prints each key and executes each Gerbil's <code>Hop</code> function
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer, Gerbil> gerbils = new HashMap();
        
        for (int i=0; i < 10; ++i) {
            gerbils.put(Gerbil.GetCurrentID(), new Gerbil());
        }
        
        Iterator gerbiliter = gerbils.keySet().iterator();
        GerbilHashMap theGuys = new GerbilHashMap((HashMap) gerbils);
        theGuys.RollCall(gerbiliter);        
    }
    
}

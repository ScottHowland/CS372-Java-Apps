/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_1;
import java.util.ArrayList;
/**
 * Displays the ID numbers and hopping status of an ArrayList of Gerbils using <code>get()</code>
 * @author showland17
 */
public class PR2_1 {

    /**
     * Adds 10 Gerbils to an ArrayList, then calls the <code>Hop</code> method of each
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList gerbils = new ArrayList();
        
        for (int i=0; i < 10; ++i) {
            gerbils.add(new Gerbil());
        }
        
        for (int i=0; i < gerbils.size(); ++i) {
            Gerbil temp_gerbil = (Gerbil)gerbils.get(i);
            temp_gerbil.Hop();
        }
    }
    
}

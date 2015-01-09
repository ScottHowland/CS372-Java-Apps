/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_1;
import java.util.ArrayList;

/**
 * A GerbilArray is able to tell all the Gerbils in its charge to <code>Hop</code>
 * @author showland17
 */
public class GerbilArray {
    private ArrayList<Gerbil> gerbils;
    
    public GerbilArray(ArrayList<Gerbil> gerbils) {
        this.gerbils = gerbils;
    }
    
    public void CommenceHopping() {
        for (Gerbil gerbil : gerbils) {
            gerbil.Hop();
        }
    }
}

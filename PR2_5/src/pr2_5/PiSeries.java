/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_5;
import java.lang.Math;


/**
 * Contains the depth of a Leibniz infinite Pi series, as well as the means to
 * approximate Pi by performing a calculation on said series
 * @author showland17
 */
public class PiSeries {
    /** 
     * Used to determine how many elements will be used in the infinite series 
     * calculation
     */
    private int series_depth;
    
    /**
     * Assigns the series' depth
     * @param user_depth The number of elements to be used in the series calculation
     */
    public PiSeries(int user_depth) {
        series_depth = user_depth;
    }
    
    /**
     * Calculates an approximation of Pi based on this series' depth
     * @return The approximated value of Pi using a Leibniz infinite series]
     * calculation
     */
    public float CalcSeries() {
        float calculation = 0;
        
        for (int i=0; i < series_depth; ++i) {
            calculation += (Math.pow(-1,i) * 4 / (i*2 + 1));
        }
        
        return calculation;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_4;

/**
 * A PiSeriesCalculator will execute one Leibniz Pi approximation based on an
 * argument-derived series length, then one approximation with a length of 200000
 * @author showland17
 */
public class PiSeriesCalculator {
    public void CalcSeries(int seriesDepth) {
      PiSeries series = new PiSeries(seriesDepth);
      System.out.printf("Pi using a series of %d elements: %f.\n" , seriesDepth, series.CalcSeries());
       
      series = new PiSeries(200000);
      System.out.printf("Pi using a series of 200000 elements: %f.\n", series.CalcSeries());
    }
}

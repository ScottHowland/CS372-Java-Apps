/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_4;
import java.util.Scanner;
/**
 * Allows a user to calculate a Leibniz Pi infinite series using a custom number
 * of elements, alongside viewing the results of a 200k element calculation
 * @author showland17
 */
public class PR2_4 {

    /**
     * Creates a PiSeries and then calculates a Leibniz Pi value using a 
     * user-defined number of terms. Then prints the result of a 200,000 term
     * Leibniz Pi series calculation
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      //PT -- should prompt the user before waiting for input. -2
      int seriesDepth = scanner.nextInt();
      PiSeriesCalculator ourSeries = new PiSeriesCalculator();
      ourSeries.CalcSeries(seriesDepth);
    }
}

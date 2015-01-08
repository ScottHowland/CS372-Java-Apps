/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_5;
import java.util.Random;
/**
 * Compares 25 random integers against another one, then prints their comparisons
 * @author Scott
 */
public class PR1_5 {

    /**
     * Calculates a random integer, then 25 more and compares them. The results of these comparisons are printed to screen.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //PT: This is a place where making a separate class might be useful. It's
        //    not necessary, obviously, but it's good to get in the habit of separating
        //    things out
        Random rand = new Random();
        int keystone = rand.nextInt(100) + 1;
        int random;
        
        for (int i = 0; i < 25; i++) {
            random = rand.nextInt(100) + 1;
            
            if (random < keystone)
                System.out.printf("%d < %d.\n", random, keystone);
            
            else if (random == keystone)
                System.out.printf("%d = %d.\n", random, keystone);
            
            else
                System.out.printf("%d > %d.\n", random, keystone);
        }
    }
    
}

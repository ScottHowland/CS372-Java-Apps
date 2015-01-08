/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foodbank;

import java.util.Random;
import foodbank.food.*;
/**
 *
 * @author showland17
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rnd = new Random();
        FoodContainer lootCrate = new FoodContainer();
        
        int c = rnd.nextInt(50) + 20;
        
        for (int i=0; i<c; i++) {
            if (rnd.nextBoolean())
                lootCrate.addGood(new Soup(rnd.nextInt(30) + 10, rnd.nextInt(50) + 10, 0));
            else
                lootCrate.addGood(new Coffee(rnd.nextInt(50) + 10, rnd.nextInt(150) +10, 0));
        }
        
       System.out.printf("Total number of items: %d.\n", lootCrate.getCount());
       System.out.printf("Total weight: %d.\n", lootCrate.getWeight());
       System.out.printf("Total volume: %d.\n", lootCrate.getVolume());
    }
    
}

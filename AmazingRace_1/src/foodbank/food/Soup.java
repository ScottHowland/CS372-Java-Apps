/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foodbank.food;

/**
 * Soup is a child of FoodItem which has a unique <code>heat</code> behavior
 * @author showland17
 */
public class Soup extends FoodItem {
    /**
     * No changes from the FoodItem constructor
     * @param weight The weight-to-be of the item
     * @param volume the volume-to-be of the item
     */
    public Soup(int weight, int volume, int currentTime) {
        super(weight, volume, currentTime);
        expirationTime = currentTime + 9001;        
    }
    
    public String toString() {
        return "Soup";
    }
    
    public void Heat() {
        System.out.println("Burnin' down the house.\n");
    }
    
}

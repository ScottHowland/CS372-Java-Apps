/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foodbank.food;

/**
 * Coffee is a child of FoodItem which has a unique <code>Grind</code> behavior
 * @author showland17
 */
public class Coffee extends FoodItem {
    /**
     * No changes from the FoodItem constructor
     * @param weight The weight-to-be of the object
     * @param volume The volume-to-be of the object
     */
    public Coffee(int weight, int volume, int currentTime) {
        super(weight, volume, currentTime);
        expirationTime = currentTime + 9001;
    }
    
    public String toString() {
        return "Coffee";
    }
    
    /**
     * Coffee-specific behavior which prints a unique message to the console
     */
    public void Grind() {
        System.out.println("Operation: BlitzGrind commencing.\n");
    }
}

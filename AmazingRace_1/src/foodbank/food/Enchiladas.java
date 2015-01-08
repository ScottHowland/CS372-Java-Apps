/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foodbank.food;

/**
 *
 * @author showland17
 */
public class Enchiladas extends FoodItem {
    /**
     * No changes from the FoodItem constructor
     * @param weight The weight-to-be of the object
     * @param volume The volume-to-be of the object
     */
    public Enchiladas(int weight, int volume, int currentTime) {
        super(weight, volume, currentTime);
        expirationTime = currentTime + 4052;
    }
    
    public String toString() {
        return "Enchiladas";
    }
    
    /**
     * Coffee-specific behavior which prints a unique message to the console
     */
    public void Grind() {
        System.out.println("Now microwaving.\n");
    }
}

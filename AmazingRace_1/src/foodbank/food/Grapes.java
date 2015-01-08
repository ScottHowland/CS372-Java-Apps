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
public class Grapes extends FoodItem {
    /**
     * No changes from the FoodItem constructor
     * @param weight The weight-to-be of the object
     * @param volume The volume-to-be of the object
     */
    public Grapes(int weight, int volume, int currentTime) {
        super(weight, volume, currentTime);
        expirationTime = currentTime + 1000;
    }
    
    public String toString() {
        return "Grapes";
    }
    
    /**
     * Grape-specific behavior which prints a unique message to the console
     */
    public void Stomp() {
        System.out.println("Stomping sequence initiated.\n");
    }
}

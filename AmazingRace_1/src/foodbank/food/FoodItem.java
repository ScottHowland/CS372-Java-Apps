/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foodbank.food;

import java.util.Random;
/**
 * Food items have properties describing their <code>weight</code>, 
 * <code>volume</code>, and <code>expirationTime</code>
 * @author showland17
 */
public class FoodItem {
    private int weight, volume, ID;
    protected int expirationTime;
    
    public FoodItem(int weight, int volume, int currentTime) {
        this.weight = weight; 
        this.volume = volume;
        
        Random rnd = new Random();
        ID = rnd.nextInt();
    }
    
    /**
     * Accessor for <code>weight</code>
     * @return The item's weight
     */
    public int getWeight() {
        return weight;
    }
    
    /**
     * Accessor for <code>volume</code>
     * @return The item's volume
     */
    public int getVolume() {
        return volume;
    }
      
    /**
     * Accessor for <code>ID</code>
     * @return 
     */
    public int getID() {
        return ID;
    }
    
    /**
     * Determines whether this FoodItem has expired
     */
    public boolean isExpired(int currentTime) {
        
        if (expirationTime < currentTime) {
            return false;
        }
        
        else {
            return true;
        }            
    }
}
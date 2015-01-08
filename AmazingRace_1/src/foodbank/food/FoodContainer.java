/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foodbank.food;
import java.util.HashMap;
import java.util.PriorityQueue;
/**
 * 
 * @author showland17
 */
public class FoodContainer {
    private HashMap<Integer, FoodItem> goods = new HashMap();
    private PriorityQueue<FoodItem> sortedGoods = new PriorityQueue();
    private int currentTime, totalWeight, totalVolume;
    
    public void addGood (FoodItem newGood) {
        goods.put(newGood.getID(), newGood);
        totalWeight += newGood.getWeight();
        totalVolume += newGood.getVolume();
    }
    
    public void removeGood(FoodItem good) {
        goods.remove(good.getID());
        totalWeight -= good.getWeight();
        totalVolume -= good.getVolume();
    }
    
    public void checkExpired(FoodItem good) {
        if (good.isExpired(currentTime)) {
            goods.remove(good.getID(), good);
            totalWeight -= good.getWeight();
            totalVolume -= good.getVolume();
        }
    }
    
    public void goodsPurge() {
        for (FoodItem good : goods.values()) {
            if(good.isExpired(currentTime))
                goods.remove(good.getID(), good);
        }
    }
    
    public int getCount() {
        return goods.size();
    }
    
    public int getWeight() {
        return totalWeight;
    }
    
    public int getVolume() {
        return totalVolume;
    }
}
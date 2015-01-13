/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_2;

/**
 * A Shape has abstract methods to determine its area and perimeter
 * @author showland17
 */
public class Shape {
    protected String name;
    
    /**
     * The to-be-overridden method to calculate a Shape's area
     * @return The default area for shapes
     */
    public double getArea() {return 0;}
    /**
     * The to-be-overridden method to calculate a Shape's perimeter
     * @return The default perimeter for shapes
     */
    public double getPerimeter() {return 0;}
    
    public String name() {return name;}
}

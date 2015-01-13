/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_2;

/**
 * A Rectangle is a Shape which uses a width and height value and overridden 
 * area and perimeter methods to calculate those properties
 * @author showland17
 */
public class Rectangle extends Shape {
    private int width, height;
    
    /**
     * Determine whether a Rectangle can be constructed with the supplied values.
     * Throw an IllegalArgumentException if this is impossible. Otherwise, create
     * a new Rectangle with the specified width/height values
     * @param width The width-to-be of the Rectangle
     * @param height the height-to-be of the Rectangle
     * @throws IllegalArgumentException 
     */
    public Rectangle (int width, int height, String name) throws IllegalArgumentException {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.width = width;
        this.height = height;
        this.name = name;
    }

    /**
     * A Rectangle's area is equal to width * height
     * @return The Rectangle's area
     */
    @Override 
    public double getArea() {
        return width * height;
    }
    
    /**
     * A Rectangle's perimeter is equal to twice its width plus twice its height
     * @return The Rectangle's perimeter
     */
    @Override
    public double getPerimeter() {
        return 2*width + 2*height;
    }
}

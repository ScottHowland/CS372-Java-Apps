/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_2;

/**
 * An Ellipse is a Shape which uses two radius values and overridden 
 * area and perimeter methods to calculate those properties
 * @author showland17
 */
public class Ellipse extends Shape {
    private int r1;
    private int r2;
    
    /**
     * Determine whether an Ellipse can be constructed with the supplied values.
     * Throw an IllegalArgumentException if this is impossible. Otherwise, create
     * a new Ellipse with the specified radii values
     * @param r1 The first radius value of the Ellipse
     * @param r2 the second radius value of the Ellipse
     * @throws IllegalArgumentException 
     */
    public Ellipse (int r1, int r2, String name) throws IllegalArgumentException {
        if (r1 <= 0 || r2 <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.r1 = r1;
        this.r2 = r2;
        this.name = name;
    }
    
    /**
     * @return The area of the Ellipse 
     */
    @Override
    public double getArea() {
        return Math.PI * r1 * r2; 
    }
    
    /**
     * Uses a Ramanujan approximation of the circumference of an Ellipse to determine
     * said value, then returns the approximation
     * @return The approximate circumference of the Ellipse
     */
    @Override
    public double getPerimeter() {
        double Ramanujan = Math.PI * (3*(r1+r2) - Math.pow((3*r1 + r2) * (r1 + 3*r2), .5));
        return Ramanujan;
    }
}

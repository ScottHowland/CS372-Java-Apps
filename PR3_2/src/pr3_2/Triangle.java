/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_2;

import java.text.DecimalFormat;

/**
 * A Triangle is a Shape which uses three side length values and overridden 
 * area and perimeter methods to calculate those properties
 * @author showland17
 */
public class Triangle extends Shape {
    private int s1, s2, s3;
    
    public Triangle(int s1, int s2, int s3, String name) throws IllegalArgumentException {
        if (s1 + s2 <= s3 || s1 + s3 <= s2 || s2 + s3 <= s1) {
            throw new IllegalArgumentException();
        }
        
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.name = name;
    }
    
    /**
     * A Triangle's area is calculated using Heron's Formula, using the
     * perimeter and side lengths
     * @return The Triangle's area
     */
    @Override
    public double getArea() {
        double perim = (double)(s1 + s2 + s3)/2;
        double area = (double)Math.pow(perim * (perim - s1) * (perim - s2) * (perim - s3), 0.5);
        DecimalFormat form = new DecimalFormat("#.###");
        form.format(area);
        return area;
    }
    
    /**
     * A Triangle's perimeter is equal to the combine lengths of its sides
     * @return The Triangle's perimeter
     */
    @Override
    public double getPerimeter() {
        return s1 + s2 + s3;
    }
}
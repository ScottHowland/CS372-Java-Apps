/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_6;

import java.util.ArrayList;

/**
 * A HWStatCalculator has an ArrayList containing a set of integers representing 
 * grades. Can also determine the maximum, minimum, and average grade values for
 * the ArrayList
 * @author showland17
 */
public class HWStatCalculator {
    private ArrayList<Integer> gradeBook;
    
    public HWStatCalculator() {
        gradeBook = new ArrayList();
    }
    
    /**
     * Add a new grade to the <code>gradeBook</code>
     * @param newGrade The grade to be added
     */
    public void addGrade(int newGrade) {
        gradeBook.add(newGrade);
    }
    
    /**
     * Calculates the lowest grade in the <code>gradeBook</code>
     * @return The lowest grade
     */
    public int calcMin () {
        int tempMin = 1000000;
        
        for (int i : gradeBook) {
            if (tempMin > i)
                tempMin = i;
        }
        
        return tempMin;
    }
    
    /**
     * Calculates the highest grade in the <code>gradeBoook</code>
     * @return The highest grade
     */
    public int calcMax () {
        int tempMax = 0;
        
        for (int i : gradeBook) {
            if (tempMax < i)
                tempMax = i;
        }
        
        return tempMax;
    }
    
    /**
     * Calculates the average grade in the <code>gradeBook</code>
     * @return The average grade
     */
    public int calcAverage () {
        int total = 0;
        
        for (int i : gradeBook) {
            total += i;
        }
        
        int average = (int) (total / gradeBook.size());
        return average;
    }
}

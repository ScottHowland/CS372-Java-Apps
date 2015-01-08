/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foodbank.volunteer;

/**
 * TODO: Design and implement Volunteer class
 * @author showland17
 */
public class Volunteer {
    private String name;
    private int hoursWorked;
    private boolean isWorking;
    
    public Volunteer(String name) {
        this.name = name;
    }
    
    public void addHours(int newHours) {
        hoursWorked += newHours;
    }
    
    public void currentStatus() {
        if (isWorking)
            System.out.printf("%s is currently hard at work.\n", name);
        
        else
            System.out.printf("%s is currently available.\n", name);
    }
}

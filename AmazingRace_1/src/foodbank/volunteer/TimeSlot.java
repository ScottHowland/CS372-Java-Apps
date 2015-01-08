/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foodbank.volunteer;
import java.util.Vector;

/**
 * A TimeSlot has a specific start and ending time, as well as a <code>staff</code>
 * vector which manages which volunteers are working any given shift
 * @author showland17
 */
public class TimeSlot {
    private int startTime, endTime;
    private Vector<Volunteer> staff;
    
    public TimeSlot(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public void addStaff (Volunteer newGuy) {
        staff.add(newGuy);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * An AppointmentManager contains an ArrayList of Appointments, which it can 
 * add to and sort by any of an Appointment's 3 properties
 * @author showland17
 */
public class AppointmentManager {
    private ArrayList<Appointment> appointments;
    
    public AppointmentManager() {
        appointments = new ArrayList<Appointment>();
    }
    
    public ArrayList<Appointment> appointments() {
        return appointments;
    }
    
    public void Add(Appointment s) {
        appointments.add(s);
    }
    
    /**
     * Sort the manager's Appointments by their title
     */
    public void titleSort() { 
       Collections.sort(appointments, Appointment.TitleComparator);
    }
    
    /**
     * Sort the manager's Appointments by their location
     */
    public void locationSort() {
        Collections.sort(appointments, Appointment.LocationComparator);
    }
    
    /**
     * Sort the manager's Appointments by their date
     */
    public void dateSort() {
        Collections.sort(appointments, Appointment.DateComparator);
    }
}

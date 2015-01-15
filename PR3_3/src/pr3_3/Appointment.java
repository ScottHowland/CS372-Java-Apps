/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_3;

import java.util.Comparator;

/**
 * An Appointment contains a title, location, and date, as well as accessors and
 * comparators to allow sorting of those values
 * @author showland17
 */
public class Appointment {
    private String title;
    private String location;
    private String date;
    
    public static Comparator<Appointment> TitleComparator = new Comparator<Appointment>() {
        @Override
        public int compare(Appointment a1, Appointment a2) {
            int cmp = a1.Title().compareTo(a2.Title());
            if (cmp == 0) 
                cmp = a1.Date().compareTo(a2.Date());
            if (cmp == 0)
                cmp = a1.Location().compareTo(a2.Location());
            return cmp;
        }
    };
    
    public static Comparator<Appointment> LocationComparator = new Comparator<Appointment>() {
        @Override
        public int compare(Appointment a1, Appointment a2) {
            int cmp = a1.Location().compareTo(a2.Location());
            if (cmp == 0) 
                cmp = a1.Date().compareTo(a2.Date());
            if (cmp == 0)
                cmp = a1.Title().compareTo(a2.Title());
            return cmp;
        }
    };
    
    public static Comparator<Appointment> DateComparator = new Comparator<Appointment>() {
        @Override
        public int compare(Appointment a1, Appointment a2) {
            int cmp = a1.Date().compareTo(a2.Date());
            if (cmp == 0) 
                cmp = a1.Location().compareTo(a2.Location());
            if (cmp == 0)
                cmp = a1.Title().compareTo(a2.Title());
            return cmp;
        }
    };
    
        public Appointment (String title, String location, String date) {
        this.title = title;
        this.location = location;
        this.date = date;
    }
    
    public String Title() {
        return title;
    }
    
    public String Location() {
        return location;
    }    
    
    public String Date() {
        return date;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr4_1;

/**
 * A <code>Review</code> is a collection of information relevant to a user-created review
 * of a given establishment.  
 * @author Scott
 */
public class Review {
    private String establishmentName, address, notes;
    private Integer rating;
    
    public Review (String name, String address, String notes, int rating) {
        this.establishmentName = name;
        this.address = address;
        this.notes = notes;
        this.rating = rating;
    }
    
    public String establishment() {
        return establishmentName;
    }
    
    public String address() {
        return address;
    }
    
    public String notes() {
        return notes;
    }
    
    public Integer rating() {
        return rating;
    }
    
    public void setFields(String name, String address, String notes, int rating) {
        this.establishmentName = name;
        this.address = address;
        this.notes = notes;
        this.rating = rating;
    }
}

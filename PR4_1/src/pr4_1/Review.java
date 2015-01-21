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
    
    /**
     * Establishes the fields to be used by the <code>Review</code>
     * @param name The name of the restaurant being reviewed
     * @param address The address/location of the restaurant being reviewed
     * @param notes The review body, or supplemental notes
     * @param rating The rating given to the restaurant, out of five
     */
    public Review (String name, String address, String notes, int rating) {
        this.establishmentName = name;
        this.address = address;
        this.notes = notes;
        this.rating = rating;
    }
    
    /**
     * @return The name of the restaurant being reviewed
     */
    public String establishment() {
        return establishmentName;
    }
    
    /**
     * @return The location of the restaurant being reviewed
     */
    public String address() {
        return address;
    }
    
    /**
     * @return The review body, or notes about the restaurant
     */
    public String notes() {
        return notes;
    }
    
    /**
     * @return The rating of the restaurant, out of 5
     */
    public Integer rating() {
        return rating;
    }
}
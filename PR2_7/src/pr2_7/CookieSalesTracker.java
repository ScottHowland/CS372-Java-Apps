/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr2_7;

/**
 * A CookieSalesTracker records the sales and gross profits of the cookie selling
 * operation
 * @author showland17
 */
public class CookieSalesTracker {
    private int priceTM, priceSomoa, priceCChip;
    private int numTMints, numSomoas, numCChips;
    private int salesTMints, salesSomoas, salesCChips;
    
    /**
     * Upon creation, a CookieSalesTracker sets the sales prices for each
     * cookie type
     * @param priceTM Price of Thin Mints
     * @param priceSomoa Price of Somoas
     * @param priceCChip Price of Chocolate Chip
     */
    public CookieSalesTracker(int priceTM, int priceSomoa, int priceCChip) {
        this.priceTM = priceTM;
        this.priceSomoa = priceSomoa;
        this.priceCChip = priceCChip;
    }
    
    /**
     * Updates the quantity of Thin Mints sold and their profit total
     * @param i The number of units being sold
     */
    public void SellTM(int i) {
        numTMints += i;
        salesTMints += priceTM * i;
    }
    
    /**
     * Updates the quantity of Somoas sold and their profit total
     * @param i The number of units being sold
     */
    public void SellSomoa(int i) {
        numSomoas += i;
        salesSomoas += priceSomoa * i;
    }
    
    /**
     * Updates the quantity of Chocolate Chip cookies sold and their profit total
     * @param i The number of units being sold
     */
    public void SellCChip(int i) {
        numCChips += i;
        salesCChips += priceCChip * i;
    }
    
    public int getTMSales() {
        return salesTMints;
    }
    
    public int getSSales() {
        return salesSomoas;
    }
    
    public int getCCSales() {
        return salesCChips;
    }
    
    public int getTMNum() {
        return numTMints;
    }
    
    public int getSNum() {
        return numSomoas;
    }
    
    public int getCCNum() {
        return numCChips;
    }
}

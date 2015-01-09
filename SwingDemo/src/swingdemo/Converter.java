/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swingdemo;

/**
 *
 * @author showland17
 */
public class Converter {
    private double currentCelsius;
    
    public Converter (double c) {
        setCelsius(c);
    }
    
    public double getCelsius () {
        return currentCelsius;
    }
    
    public void setCelsius (double c) {
        currentCelsius = c;
    }
    
    public double toFahrenheit() {
        return currentCelsius * (9/5.0) + 32;
    }
}

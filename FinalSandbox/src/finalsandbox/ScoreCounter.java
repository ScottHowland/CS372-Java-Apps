/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalsandbox;

import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Scott
 */
public class ScoreCounter {
    private Integer turnCounter;
    private String counterText;
    
    public ScoreCounter () {
        turnCounter = 0;
    }
    
    public void drawScore (Graphics g) {
        String fontName = g.getFont().getFontName();
        String clickPlurality;
        g.setFont(new Font (fontName, Font.PLAIN, 36));
        
        if (turnCounter == 1)
            clickPlurality = " click";
        else
            clickPlurality = " clicks";
        
        counterText = "Score: " + turnCounter.toString() + clickPlurality;
        g.drawString(counterText, 415, 100);
    }
    
    public void incCounter() {
        turnCounter++;
    }
    
    public void resetCounter() {
        turnCounter = 0;
    }
    
    public Integer turnCounter() {
        return turnCounter;
    }
}

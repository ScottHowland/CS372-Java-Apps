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
public class HSDisplay {
    private Integer bestScore;
    private String displayText;
    
    public HSDisplay (Integer highScore) {
        this.bestScore = highScore;
    }
    
    public void drawHS (Graphics g) {
        String fontName = g.getFont().getFontName();
        String clickPlurality;
        g.setFont(new Font (fontName, Font.PLAIN, 36));
        
        if (bestScore == 1)
            clickPlurality = " click";
        else
            clickPlurality = " clicks";
        
        displayText = "Best Score: " + bestScore.toString() + clickPlurality;
        g.drawString(displayText, 415, 50);
    }
    
    public void setBestScore (Integer newHS) {
        bestScore = newHS;
    }
    
    public Integer bestScore() {
        return bestScore;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalsandbox;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 * The BackgroundMusic class is to be used for playing an audio file on 
 * a thread separate from the main application thread, including those formats
 * supported by JavaZoom. The music can be played once or set to loop continuously
 * @author Scott Howland
 */
public class BackgroundMusic implements Runnable {
    //The file path to the music to be looped
    private final String musicName;
    //Whether or not the music will be looped
    private boolean loop;
    
    /**
     * @param musicName The file path to the music to be looped 
     */
    public BackgroundMusic(String musicName, boolean loop) {
        this.musicName = musicName;
        this.loop = loop;
    }
    
    /**
     * Loops the audio file
     */
    @Override
    public void run() {
        playSoundLoop(musicName, loop);
    }
    
    /**
     * Unless there is an error in the file path to the audio file, will play 
     * the specified audio file on a loop until the BackgroundMusic is terminated
     * @param musicPath The file path to the music to be looped
     */
    private void playSoundLoop(String musicPath, boolean loop){
        do {
            try {
                //Create a file based on the file path, then a buffered input stream 
                //based on that file
                File file = new File(musicPath);
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                AdvancedPlayer p = new AdvancedPlayer((InputStream) bis);             
                p.play();
            }       
            catch (Exception ex) {
                Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while(loop);
    }
    
}

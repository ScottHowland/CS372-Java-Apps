/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalsandbox;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;

/**
 * The BackgroundMusic class is to be used for looping an audio file on 
 * a thread separate from the main application thread, including those
 * supported by JavaZoom
 * @author Scott Howland
 */
public class BackgroundMusic implements Runnable {
    //The file path to the music to be looped
    private final String musicName;
    
    /**
     * @param musicName The file path to the music to be looped 
     */
    public BackgroundMusic(String musicName) {
        this.musicName = musicName;
    }
    
    /**
     * Loops the audio file
     */
    @Override
    public void run() {
        playSoundLoop(musicName);
    }
    
    /**
     * Unless there is an error in the file path to the audio file, will play 
     * the specified audio file on a loop until the BackgroundMusic is terminated
     * @param musicPath The file path to the music to be looped
     */
    private void playSoundLoop(String musicPath){
        try {
            //Create a file based on the file path, then a buffered input stream 
            //based on that file
            File file = new File(musicPath);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            //Attempt to play the audio file on a loop
            try {
                AdvancedPlayer p = new AdvancedPlayer((InputStream) bis);
                p.setPlayBackListener(new PlaybackListener() {
                    //Will replay the audio file once done playing
                    @Override
                    public void playbackFinished(PlaybackEvent evt) {
                        try {
                            p.play();
                        }
                        catch (JavaLayerException ex) {
                            Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
                        };
                    }
                });
                
                p.play();
            }
            catch (JavaLayerException ex) {
                Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        catch (FileNotFoundException ex) {
            Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalsandbox;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;

/**
 *
 * @author showland17
 */
public class AudioManager {
     public void playSoundOnce(String musicname) {
        try {
            AudioClip sound = Applet.newAudioClip(new URL("file:./"+musicname));
            sound.play();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playSoundLoop(String musicname){
        /*try {
            Media tune = new Media(Paths.get(musicname).toUri().toString());
            MediaPlayer musicPlayer = new MediaPlayer(tune);
            musicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            musicPlayer.play();
        } catch (Exception ex) {
            Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
          }*/
        try {
            File file = new File(musicname);
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            try {
                AdvancedPlayer p = new AdvancedPlayer((InputStream) bis);
                p.setPlayBackListener(new PlaybackListener() {
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

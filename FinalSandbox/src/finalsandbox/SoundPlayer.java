/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalsandbox;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 * The SoundPlayer class is to be used for playing short, sound effects in 
 * natively Java-supported audio formats (.WAV, .AU, etc)
 * @author Deyi Ji
 */
public class SoundPlayer {
    /**
     * Will play the sound specified by a given file path once
     * @param soundPath The file path to the sound effect to be played
     */
    private AudioClip sound;
    
     public void playSoundOnce(String soundPath) {
        //Helps prevent the buffer from overflowing. Much less stuttering
        //in gameplay now that the clip clears itself before playing the next sound
        if (sound != null)
            sound.stop();        
        try {
            sound = Applet.newAudioClip(new URL("file:./"+soundPath));
            sound.play();
        } catch (MalformedURLException ex) {
            Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
    }    
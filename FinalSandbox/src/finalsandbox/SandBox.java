/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalsandbox;

import java.util.Arrays;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The SandBox houses the entirety of the application. It uses a JFrame to 
 * control the JPanel which displays the grid, plays sounds, and manages user input.
 * Also contains the main function for the application, which creates a new instance
 * of SandBox and plays the background music on a loop in a background thread
 * until the JFrame is closed
 * @author Scott Howland, Deyi Ji
 */
public class SandBox {
   private HexGrid grid;
   private JFrame screen;
   private SoundPlayer dj;
    
   /**
    * Initializes the components of the SandBox
    */
    public SandBox() {
        initComponents();
    }
    
    /**
     * Creates a JPanel responsible for drawing the game grid as well as 
     * listen for and handle user input. The JPanel is then added to the JFrame
     */
    private void initComponents() {
        screen = new JFrame();
        screen.setResizable(false);
        screen.getContentPane().setBackground(Color.red);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid = new HexGrid();
        dj = new SoundPlayer();
              
       /**
        * A JPanel will be able to draw the grid on demand, fit itself to a specified
        * resolution, as well as listen for, and respond to, user input
        */
       JPanel p;
       p = new JPanel() {
           /**
            * Draws each HexTile in the grid
            * @param g The system-supplied Graphics object to be used in the drawing process
            */
           @Override
           public void paint (Graphics g) {
               for (HexTile value : grid.tiles().values()) {
                   value.draw(g);
               }
           }
           
           /**
            * @return The preferred size of the JPanel
            */
           @Override
           public Dimension getPreferredSize() {
               return new Dimension(800,600);
           }          
       };       
        
       /**
        * Equip the JPanel with a MouseListener which will toggle the 
        * tile clicked by a user, as well as its neighbors, before redrawing
        * the grid
        */
        p.addMouseListener(new MouseListener() { 
        
        @Override
        public void mouseReleased(MouseEvent e) {
            toggleTiles(e, p);
        }
        
        @Override 
        public void mouseClicked(MouseEvent e) {           
        }    
        @Override
        public void mouseEntered(MouseEvent e) {   
        }    
        @Override
        public void mouseExited(MouseEvent e) {
        }    
        @Override
        public void mousePressed(MouseEvent e) {
        }
        });
    
        screen.add(p);
        screen.pack();
        screen.setVisible(true);
    }
    
    private void toggleTiles(MouseEvent e, JPanel p) {
        for (HexTile tile : grid.tiles().values()) {
                if (tile.contains(e.getPoint())) {
                    dj.playSoundOnce(tile.soundPath());
                    ArrayList<HexTile> toggleTargets = includeNeighbors(tile);
                    
                    for (HexTile hex : toggleTargets)
                        hex.toggle();
                    p.repaint();
                    
                    if (grid.isWinCondition())
                        victory();
                    break;
                }
            }        
    }
    
    private void victory() { 
       JPanel p = new JPanel();
    }

    /**
     * Determines and collects all the neighbors of a given HexTile
     * @param centerTile The tile whose neighbors are to be collected
     * @return An ArrayList including the given tile and its neighbors
     */
    private ArrayList<HexTile> includeNeighbors(HexTile centerTile) {
        ArrayList<HexTile> toggleTargets = new ArrayList();
        toggleTargets.add(centerTile);
        int[][] neighborCoords = centerTile.neighborGridCoords();
        String neighborKey="";
        HexTile temp = null;
        
        for (int[] i : neighborCoords) {
            neighborKey = Arrays.toString(i);
            if (grid.tiles().containsKey(neighborKey)) {
                temp = grid.tiles().get(neighborKey);
                toggleTargets.add(temp);
            }
        }
        return toggleTargets;
    }
    
    /**
     * Creates a new SandBox to create an instance of the game, as well as
     * running the looping background music in a new thread
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Thread(new BackgroundMusic("Music/background.mp3", true)).start();
                new SandBox();
            }
        });        
    }
    
}

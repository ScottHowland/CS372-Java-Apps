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
import java.io.File;
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

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
   private ArrayList<Integer> scores;
   private File dir, scoreDB;
   private HexGrid grid;
   private HSDisplay recordDisplay;
   private Integer bestScore;
   private JFrame screen;
   private JPanel gamePanel;
   private ScoreCounter playerScore;
   private ScoreIO scoreManager;
   private SoundPlayer dj;
    
   /**
    * Initializes the components of the SandBox
    */
    public SandBox() {
        setupFiles();
        initComponents();
    }
    
    /**
     * Creates any necessary directories to allow the creation of the text file
     * tracking the user's scores
     */
    private void setupFiles() {
        dir = new File("Player Stats");
        try {
            dir.mkdirs();
        }
        catch (Exception ex) {
            Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        scoreDB = new File(dir, "scores.txt");
        try {
            scoreDB.createNewFile();
        }
        catch (IOException ex) {
             Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates a JPanel responsible for drawing the game grid as well as 
     * listen for and handle user input. The JPanel is then added to the JFrame
     */
    private void initComponents() {
        dj = new SoundPlayer();
        grid = new HexGrid();
        playerScore = new ScoreCounter();
        scoreManager = new ScoreIO();
        scores = new ArrayList();
        screen = new JFrame();
        try {
            scoreManager.readScores(scoreDB, scores);
            calcBestScore();
        }
        catch (Exception ex) {
            Logger.getLogger(SandBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        recordDisplay = new HSDisplay(bestScore);
        
       /**
        * A JPanel will be able to draw the grid on demand, fit itself to a specified
        * resolution, as well as listen for, and respond to, user input
        */
       gamePanel = new JPanel() {
           /**
            * Draws each HexTile in the grid
            * @param g The system-supplied Graphics object to be used in the drawing process
            */
           @Override
           public void paint (Graphics g) {
               super.paintComponent(g);
               for (HexTile value : grid.tiles().values()) {
                   value.draw(g);
               }
               playerScore.drawScore(g);
               recordDisplay.drawHS(g);
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
        gamePanel.addMouseListener(new MouseListener() { 
        
        @Override
        public void mouseReleased(MouseEvent e) {
            toggleTiles(e);
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
        
        screen.setResizable(false);
        screen.getContentPane().setBackground(Color.red);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.add(gamePanel);
        screen.pack();
        screen.setVisible(true);
    }
    
    /**
     * Given a Hextile, determine what neighbors it has in the HexGrid, add
     * the given tile and all its neighbor tiles to an ArrayList, then return
     * that Arraylist
     * @param e The event triggering the toggling of tiles
     */
    private void toggleTiles(MouseEvent e) {
        for (HexTile tile : grid.tiles().values()) {
                if (tile.contains(e.getPoint())) {
                    dj.playSoundOnce(tile.soundPath());
                    ArrayList<HexTile> toggleTargets = includeNeighbors(tile);
                    
                    for (HexTile hex : toggleTargets)
                        hex.toggle();
                    playerScore.incCounter();
                    gamePanel.repaint();
                    
                    if (grid.isWinCondition())
                        victory();
                    break;
                }
            }        
    }
    
    /**
     * Triggers when the player has achieved the game's win condition. 
     * Set the final score for this round, then add that to the list of scores.
     * Assess whether this latest score is the user's best. If it is, 
     * set it to display that score in-game. Reset the grid and turn counter, then
     * repaint the screen.
     */
    private void victory() {
        Integer finalScore = playerScore.turnCounter();
        scores.add(finalScore);
        calcBestScore();
        recordDisplay.setBestScore(bestScore);
        scoreManager.writeScore(scoreDB, finalScore);
        playerScore.resetCounter();
        grid = new HexGrid();
        gamePanel.repaint();
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
     * Determine which, of the player's previous scores, is the best
     */
    private void calcBestScore() {
        int tempBest = 99999;
        if (!scores.isEmpty()) {
            for (int i=0; i < scores.size(); i++) {
                int currScore = scores.get(i);
                if (currScore < tempBest)
                    tempBest = currScore;
            }
        }
        bestScore = tempBest;
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
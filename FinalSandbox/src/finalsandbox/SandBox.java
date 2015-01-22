/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalsandbox;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Scott
 */
public class SandBox {
   private HexGrid grid;
   private JFrame screen;   
    
    public SandBox() {
        initComponents();
    }
    
    private void initComponents() {
        screen = new JFrame();
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        grid = new HexGrid();
        
        JPanel p;
       p = new JPanel() {
           @Override
           public void paint (Graphics g) {
               Iterator iter = grid.iter();
               for (HexTile value : grid.tiles().values()) {
                   value.draw(g);
               }
           }
           
           @Override
           public Dimension getPreferredSize() {
               return new Dimension(800,600);
           }
       };
        
    p.addMouseListener(new MouseListener() { 
        @Override public void mouseClicked(MouseEvent e) {
            Iterator iter = grid.tiles().entrySet().iterator();
            for (HexTile tile : grid.tiles().values()) {
                if (tile.contains(e.getX(), e.getY())) {
                    tile.toggle();
                    p.repaint();
                }
            }        
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
    
        @Override
        public void mouseReleased(MouseEvent e){
        }
        });
    
        screen.add(p);
        screen.pack();
        screen.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SandBox();
            }
        });
        
    }
    
}

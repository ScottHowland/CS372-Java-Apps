/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalsandbox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Scott
 */
public class SandBox {
    private HexTile tile = new HexTile(50,0,0,0);
    private HexTile tile2 = new HexTile(50,0,-1,1);
    private HexTile tile3 = new HexTile(50,1,-1,0);
    private HexTile tile4 = new HexTile (50,1,-2,1);
    private HexTile tile5 = new HexTile (50,0,-2,2);
    private HexTile tile6 = new HexTile (50,2,-2,0);
    private HexTile tile7 = new HexTile (50,2,-1,-1);
    private HexTile[] grid = {tile, tile2, tile3, tile4, tile5, tile6, tile7};
    private JFrame screen;    
    
    public SandBox() {
        initComponents();
    }
    
    private void initComponents() {
        screen = new JFrame();
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel p = new JPanel() {
            @Override
            public void paint (Graphics g) {
                for (HexTile t : grid) {
                g.setColor(Color.red);
                g.fillPolygon(t.cornerXCords(), t.cornerYCords(), 6);
                g.setColor(Color.black);
                g.drawPolygon(t.cornerXCords(), t.cornerYCords(), 6);
                }
            }
        
          @Override
            public Dimension getPreferredSize() {
                return new Dimension(800,600);
            }
        };
        
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

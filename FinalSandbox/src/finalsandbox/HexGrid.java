/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalsandbox;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Iterator;

/**
 * The HexGrid contains the containers organizing the setup of the game grid, 
 * as well as methods for generating the position of the active lights at the 
 * start of the game
 * @author showland17
 */
public class HexGrid {
    //Stores the gridspace coordinates of every tile to be created
    private static final int[][] tileCoords = { {0,-1,1}, {0,-2,2}, {0,-3,3}, {0,-4,4}, {0,-5,5},
                                                    {1,-1,0}, {1,-2,1}, {1,-3,2}, {1,-4,3}, {1,-5,4},
                                                    {2,-1,-1}, {2,-2,0}, {2,-3,1}, {2,-4,2}, {2,-5,3},
                                                    {3,-2,-1}, {3,-3,0}, {3,-4,1}, {3,-5,2}, {3,-6,3},
                                                    {4,-3,-1}, {4,-4,0}, {4,-5,1}, {4,-6,2}, {4,-7,3}};
    private static final int[] tileLights = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private static final int[] tileSounds = {5,4,3,2,1,5,4,3,2,1,5,4,3,2,1,5,4,3,2,1,5,4,3,2,1};
    private static final int TILE_RADIUS = 50;
    private static final int NUM_LIT_TILES = 8;
    private final HashMap<String, HexTile> tiles;
    private final Iterator iter;
    private final Random rand;
    
    public HexGrid() {
        rand = new Random();
        tiles = new HashMap();
        setLighting();
        boolean isLit;
        for (int i=0; i < tileLights.length; i++) {
            isLit = false;
            if (tileLights[i] == 1)
                isLit = true;
            
            String sound = calcSoundPath(i);
            
            int[] coords = tileCoords[i];
            tiles.put(Arrays.toString(coords), new HexTile(TILE_RADIUS, coords[0], coords[1], coords[2], isLit, sound));
        }
        iter = tiles.entrySet().iterator();
    }
    
    private void setLighting() {
        int litIndex;
        ArrayList<Integer> indexList = new ArrayList();
        for (int i=0; i < tileCoords.length; i++) {
            indexList.add(i);
        }
        Collections.shuffle(indexList);

        for (int i=0; i < NUM_LIT_TILES; i++) {
            litIndex = indexList.get(i);
            tileLights[litIndex] = 1;
        }
    }
    
    private String calcSoundPath(int tileIndex) {
        Integer soundKey = tileSounds[tileIndex];
        String path = "Music/tileTouch" + soundKey.toString() + ".wav";
        return path;
    }
    
    public HashMap<String, HexTile> tiles() {
        return tiles;
    }
    
    public Iterator iter() {
        return iter;
    }
}

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
    private static final int[][] tileParams = { {0,-1,1,0}, {0,-2,2,0}, {0,-3,3,0}, {0,-4,4,0}, {0,-5,5,0},
                                                    {1,-1,0,0}, {1,-2,1,0}, {1,-3,2,0}, {1,-4,3,0}, {1,-5,4,0},
                                                    {2,-1,-1,0}, {2,-2,0,0}, {2,-3,1,0}, {2,-4,2,0}, {2,-5,3,0},
                                                    {3,-2,-1,0}, {3,-3,0,0}, {3,-4,1,0}, {3,-5,2,0}, {3,-6,3,0},
                                                    {4,-3,-1,0}, {4,-4,0,0}, {4,-5,1,0}, {4,-6,2,0}, {4,-7,3,0}};
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
        for (int[] i : tileParams) {
            isLit = false;
            if (i[3] == 1)
                isLit = true;
                
            tiles.put(Arrays.toString(i), new HexTile(TILE_RADIUS, i[0], i[1], i[2], isLit));
        }
        iter = tiles.entrySet().iterator();
    }
    
    private void setLighting() {
        int litIndex;
        ArrayList<Integer> indexList = new ArrayList();
        for (int i=0; i < tileParams.length; i++) {
            indexList.add(i);
        }
        Collections.shuffle(indexList);
        
        int[] usedIndices = new int[NUM_LIT_TILES];
        for (int i=0; i < NUM_LIT_TILES; i++) {
            litIndex = indexList.get(i);
            tileParams[litIndex][3] = 1;
        }
    }
    
    public HashMap<String, HexTile> tiles() {
        return tiles;
    }
    
    public Iterator iter() {
        return iter;
    }
}

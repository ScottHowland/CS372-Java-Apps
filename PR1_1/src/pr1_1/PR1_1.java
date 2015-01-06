/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_1;

/**
 *
 * @author Scott
 */
public class PR1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataOnly d = new DataOnly();
        
        d.i = 47;
        d.f = 1.1f;
        d.b = false;
        
        /* Print the first integer, first float, and first boolean in the argument list */
        System.out.printf("Integer: %d, Float: %2f, Boolean: %s.\n", d.i, d.f, d.b);
    }
    
}

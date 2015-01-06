/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_2;

/**
 * Homework Assignment 1, PR1_2, CS372, Pete Tucker
 * @author Scott
 */
public class PR1_2 {

    /**
     * @param args the command line arguments
     */
    
    /** Print the first three arguments from the console, if applicable */
    public static void main(String[] args) {
        
        /** Ensure that the args array has enough arguments to prevent OOB errors */
        if (args.length >= 3) {
            for(int i = 0; i < 3; ++i) {
                String k = args[i];
                System.out.println(k);
            }
        }
    }
    
}

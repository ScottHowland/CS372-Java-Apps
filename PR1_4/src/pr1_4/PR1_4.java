/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_4;

import java.util.Scanner;
/**
 * Calculates and prints a circle's area based on an integer scanned from user input
 * @author Scott
 */
public class PR1_4 {

    /**
     * @param args the command line arguments
     * Acquires an integer value from the user, then prints the area of a circle with a radius of said value
     */
    public static void main(String[] args) {
       int radius; 
       double area;
       /**
        * Final is similar to Const in C++ 
        */
       final double pi = 3.14;
       
       /* Creates a scanner holding a line of user input */
       Scanner user_input = new Scanner(System.in);
       radius = user_input.nextInt();
       area = pi * radius * radius;
       
       System.out.println(area);
    }
    
}

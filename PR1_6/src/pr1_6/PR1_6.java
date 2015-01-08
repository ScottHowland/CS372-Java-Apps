/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1_6;

/**
 * Contains a main function which will print all prime numbers from 2 to 100
 * @author Scott
 */
public class PR1_6 {

    /**
     * Contains two nested loops. For every integer 2-100:
     *     If any integer less than the integer can be divided evenly into 
     *     the first integer, then it must be prime and is printed to the screen.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for (int outerint = 2; outerint < 100; ++outerint) {
            boolean bisprime = true;
            
            //PT: Useful here to break out of the loop when you find that outerint is not prime.
            //  Also, you could break out of the loop at innerint <= outerint / 2
            // for (int innerint = 2; innerint < outerint/2 && bisprime; innerint++)
            for (int innerint = 2; innerint < outerint; ++innerint) {
                if (outerint % innerint == 0)
                    bisprime = false;
            }
            
            if (bisprime)
                System.out.printf("%d is prime.\n", outerint);
        }
    }
    
}

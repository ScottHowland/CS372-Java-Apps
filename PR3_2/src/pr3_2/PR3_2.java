/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr3_2;

/**
 *
 * @author showland17
 */
public class PR3_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        //Triangle tri = new Triangle (1,1,1);
        Triangle tri2 = new Triangle (2, 2, 3);
        //Rectangle rect = new Rectangle (0,1);
        Rectangle rect2 = new Rectangle (2,2);
        //Ellipse ell = new Ellipse (0, 1);
        Ellipse ell2 = new Ellipse (5,7);
        
        System.out.println(tri2.getArea());
        System.out.println(tri2.getPerimeter());
        System.out.println(rect2.getArea());
        System.out.println(rect2.getPerimeter());
        System.out.println(ell2.getArea());
        System.out.println(ell2.getPerimeter());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Houston, we've had a goof.\n");
        }
    }
    
}

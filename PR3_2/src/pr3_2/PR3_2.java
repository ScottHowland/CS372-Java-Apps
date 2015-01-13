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
        ShapeContainer shapeBox = new ShapeContainer();
        
        //commented Shapes should produce exceptions when uncommented
        try {
        //Triangle triExcept = new Triangle (1,9,20, "triExcept");
        Triangle tri = new Triangle (2, 2, 3, "tri");
        //Rectangle rectExcept = new Rectangle (0,1, "rectExcept");
        Rectangle rect = new Rectangle (2,2, "rect");
        //Ellipse ellExcept = new Ellipse (0, 1, "ellExcept");
        Ellipse ell = new Ellipse (5,7, "ell");
        
        shapeBox.addShapes(tri, rect, ell);
        }
        catch (IllegalArgumentException e) {
            System.out.println("A shape has unconstructable parameters.\n");
        }
        
        shapeBox.printStats();
    }
    
}

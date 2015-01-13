/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3_2;

import java.util.ArrayList;

/**
 * A ShapeContainer has an ArrayList of Shapes, as well as methods to print
 * the areas and/or perimeters of those Shapes
 * @author Scott
 */
public class ShapeContainer {
  private ArrayList<Shape> shapeContainer = new ArrayList();
  
  public void printAreas() {
      for (Shape s : shapeContainer) {
          System.out.printf("Area of %s: %.3f.\n", s.name(), (float)s.getArea());
      }
  }
  
  public void printPerims() {
      for (Shape s : shapeContainer) {
          System.out.printf("Perimeter of %s: %.3f.\n", s.name(), (float)s.getPerimeter());
      }
  }
  
  public void printStats() {
      printAreas();
      printPerims();
  }
  
  public void addShapes(Shape ... shape) {
      for (Shape s : shape) {
          shapeContainer.add(s);
      }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;
class Shape{
    public void draw(){
        System.out.println("Drawing a shape");
    }
    public void erase(){
        System.out.println("Erasing a shape");
    }
}
class Circle extends Shape{
    @Override
    public void draw(){
          System.out.println("Drawing a circle");
    }
    public void erase(){
        System.out.println("Erasing a circle");
    }
}
class Square extends Shape{
    @Override
    public void draw(){
          System.out.println("Drawing a square");
    }
    public void erase(){
        System.out.println("Erasing a square");
    }
}class Triangle extends Shape{
    @Override
    public void draw(){
          System.out.println("Drawing a triangle");
    }
    public void erase(){
        System.out.println("Erasing a triangle");
    }
}
public class Shapes {
    public static void main(String[] args) {
     Shape[]shapes=new Shape[3];
     shapes[0]=new Circle();
     shapes[1]=new Square();
     shapes[2]=new Triangle();
     for(int i=0;i<shapes.length;i++){
         shapes[i].draw();
         shapes[i].erase();
         System.out.println(".............");
     }
    }
    
}


package assig;

abstract class shape{

 String color;

 shape(String color)
 {
 this.color = color;
 }
 public String toString()
 {
 return color;
 }
 public double getArea()
 {
 return 0;
 }

}
class rectangle extends shape{
 int length , width;
 int total;
 public rectangle(String color , int length ,int width) {
 super(color);
 this.length = length;
 this.width = width;
 }
 public String toString()
 {
 return color;
 }
 public double getArea()
 {
 total = length*width;
 return total;
 }

}
class triangle extends shape{
 int base , height , total ;
 public triangle(String color , int base ,int height) {
 super(color);
 this.height = height;
 this.base = base;
 }
 public String toString()
 {
 return color;
 }
 public double getArea()
 {
 total = base*height;
 return total;
 }


}

public class question1 {

    public static void main(String[] args) {
 
 shape s1 = new rectangle("red", 4, 5); 
 System.out.println(s1); 
 System.out.println("Area is " + s1.getArea());

 shape s2 = new triangle("green", 40, 50);
 System.out.println(s2);
 System.out.println("Area is " + s2.getArea()); 

 }

}

package int101w05;

import geometry.Circle;
import geometry.complex.Donut;

public class Int101w05 {

    public static void main(String[] args) {
        Circle b = new Circle();
        Circle c = new Circle(3.0);
        System.out.println("Show me the Circles: " + b + ", " + c);
        System.out.println();

        Donut donut = new Donut(1, 4);

        System.out.println(donut.setOuterRadius(3)); // false เพราะ thickness น้อยกว่า 3
        System.out.println(donut.setOuterRadius(4)); // true เพราะ thickness >= 3
        System.out.println(donut);  // แสดงส่วนของ toString ใน class Donut.java
        System.out.println("Donut area: " + donut.computeArea()); // แสดงฟังชั่น computeArea() ของ Donut

        System.out.println();
        System.out.println();

        System.out.println(donut.setThickness(2)); // false เพราะ thickness น้อยกว่า 3
        System.out.println(donut.setThickness(5)); // false เพราะ thickness มากกว่าหรือเท่ากับ 3
        System.out.println(donut);  // แสดงส่วนของ toString ใน class Donut.java
        System.out.println("Donut area: " + donut.computeArea()); // แสดงฟังชั่น computeArea() ของ Donut

    }
}

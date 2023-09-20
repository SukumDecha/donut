package geometry.complex; // กำหนดแพ็กเกจที่คลาส Donut อยู่

import geometry.Circle; // นำเข้าคลาส Circle จากแพ็กเกจ geometry

public class Donut { // ประกาศคลาส Donut

    // สร้างค่าคงที่ชื่อ "DEFAULT_THICKNESS" ที่มีชนิด double มีค่า 3.0
    // มักจะใช้ static เวลาสร้างค่าคงที่ และจะตั้งชื่อตัวแปรของค่าคงที่ให้เป็นตัวพิมพ์ใหญ่ทุกตัว
    private static double DEFAULT_THICKNESS = 3.0;
    
    // สร้างตัวแปรชนิด Circle 2 ตัวคือ inner และ outer
    private Circle inner, outer;

    // สร้าง constructor โดยการรับค่ารัศมี inner และ outer มา
    public Donut(double innerRadius, double outerRadius) {
        this.inner = new Circle(innerRadius); // สร้างวงกลม inner ด้วยรัศมี innerRadius
        this.outer = new Circle(outerRadius); // สร้างวงกลม outer ด้วยรัศมี outerRadius
    }

    // คืนค่ารัศมีวงกลมด้านใน
    public double getInnerRadius() {
        // เข้าถึงค่ารัศมีของวงกลม inner และใช้ function getRadius() เพื่อดึงค่าของรัศมึออกมา
        return inner.getRadius();
    }

    // คืนค่ารัศมีวงกลมด้านนอก
    public double getOuterRadius() {
        // เข้าถึงค่ารัศมีของวงกลม outer และใช้ function getRadius() เพื่อดึงค่าของรัศมึออกมา
        return outer.getRadius();
    }
    
    // คืนค่าความหนาของโดนัท
    public double getThickness() {
        //วงกลมนอก - วงกลมใน
        return getOuterRadius() - getInnerRadius();
    }

    // เป็นฟังค์ชั่นที่จะส่งค่าหรือ return boolean เมื่อทำงานเสร็จกลับมา
    // โดยจะทำการเปลี่ยนรัศมึของ inner ด้วยการสร้าง new Circle() ทับผ่านการรับค่า newInner
    public boolean setInnerRadius(double newInner) {
        // ตรวจสอบว่า newInner มีค่าน้อยกว่าหรือเท่ากับ 0 หรือ newInner มากกว่าหรือเท่ากับ รัศมึวงกลมด้านนอก
        // เป็นเงื่อนไข if ที่เอาไว้กันกรณี fail ซึ่งจะ return false ถ้าตรงตามเงื่อนไข
        if (newInner <= 0 || newInner >= getOuterRadius()) return false;

      
        this.inner = new Circle(newInner); // สร้างวงกลม inner ใหม่ด้วยรัศมี newInner
        return true;
    }

    // เป็นฟังค์ชั่นที่จะส่งค่าหรือ return boolean เมื่อทำงานเสร็จกลับมา
    // โดยจะทำการเปลี่ยนรัศมึของ outer ด้วยการสร้าง new Circle() ทับผ่านการรับค่า newOuter
    public boolean setOuterRadius(double newOuter) {
        // ตรวจสอบว่า newOuter มีค่าน้อยกว่าหรือเท่ากับ DEFAULT_THICKNESS หรือ inner.getRadius() - outer น้อยกว่า DEFAULT_THICKNESS
        // เป็นเงื่อนไข if ที่เอาไว้กันกรณี fail ซึ่งจะ return false ถ้าตรงตามเงื่อนไข
        if (newOuter <= DEFAULT_THICKNESS || ((newOuter - getInnerRadius()) < DEFAULT_THICKNESS)) return false;

        this.outer = new Circle(newOuter); // สร้างวงกลม outer ใหม่ด้วยรัศมี newOuter
        return true;
    }

    /* เป็นฟังค์ชั่นที่จะส่งค่าหรือ return boolean เมื่อทำงานเสร็จกลับมา
    / โดยจะทำการเปลี่ยนความหนาของ Donut ผ่านการเปลี่ยน
    / รัศมึของ outer ด้วยการสร้าง new Circle() ทับผ่านการรับค่า inner + thickness
    */
    public boolean setThickness(double thickness) {
        // ตรวจสอบว่า thickness น้อยกว่า DEFAULT_THICKNESS
        if (thickness < DEFAULT_THICKNESS) return false;
        
        // ปรับปรุงวงกลม outer โดยใช้ inner.getRadius() + thickness
        this.outer = new Circle(getInnerRadius() + thickness);
        return true;
    }

    public double computeArea() {
        // คำนวณและคืนค่าพื้นที่ของ Donut โดยคำนวณพื้นที่วงกลม outer ลบด้วยพื้นที่วงกลม inner
        return outer.computeArea() - inner.computeArea();
    }

    @Override
    public String toString() {
        // คืนค่าสตริงที่แสดงข้อมูลของ Donut ในรูปแบบ "Donut(รัศมีภายใน, รัศมีภายนอก)"
        return String.format("Donut(%.2f, %.2f)", getInnerRadius(), getOuterRadius());
    }
}

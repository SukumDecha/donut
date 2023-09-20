package geometry;

public class Circle {
    
    private static final double DEFAULT_RADIUS = 1.0;
    private double radius; // field, instance variable, non-static variable, property
    
    public Circle() { this(DEFAULT_RADIUS); }
    public Circle(double radius) { 
        if (radius < DEFAULT_RADIUS) { 
            radius = DEFAULT_RADIUS;
        }
        this.radius = radius;
    }
    public double getRadius() { return radius; }
    public void setRadius(double radius) { // return (boolean) false if fail
        if (radius >= DEFAULT_RADIUS) {
            this.radius = radius;
        }
    }
    public double computeArea() { return Math.PI * radius * radius; }
    
    @Override
    public String toString() {
        return "Circle (" + radius + ")";
    }
}

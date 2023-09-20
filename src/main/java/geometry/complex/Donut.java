package geometry.complex;

import geometry.Circle;

public class Donut {
    private  static double DEFAULT_THICKNESS = 3.0;
    private Circle inner, outer;

    public Donut(double innerRadius, double outerRadius) {
        this.inner = new Circle(innerRadius);
        this.outer = new Circle(outerRadius);
    }

    public Donut(double radius) {
        this.inner = new Circle(radius);
    }

    public Donut() {

    }

    public double getInnerRadius() {
        return inner.getRadius();
    }

    public double getOuterRadius() {
        return outer.getRadius();
    }

    public boolean setInnerRadius(double inner) {
        if(inner <= 0 || inner >= outer.getRadius()) return  false;
        this.inner = new Circle(inner);
        return true;
    }

    public boolean setOuterRadius(double outer) {
        if(outer <= DEFAULT_THICKNESS || (inner.getRadius() - outer < DEFAULT_THICKNESS)) return  false;
        this.outer = new Circle(outer);
        return true;
    }

    public boolean setThickness(double thickness) {
        if(thickness < DEFAULT_THICKNESS) return false;

        this.outer = new Circle(this.inner.getRadius() + thickness);
        return true;
    }

    public double computeArea() {
        return outer.computeArea() - inner.computeArea();
    }

    @Override
    public String toString() {
        return String.format("Donut(%.2f, %.2f)", inner.getRadius(), outer.getRadius());
        //Donut(inner radius,outer radius)
    }

    // create a default minimum thickness of donut to 3.0 DEFAULT_THICKNESS
    //private Circle inner;
    //private Circle outer;
    
    // constructor (inner radius, outer radius) // main
    // constructor (inner radius) // delegate
    // constructor () // delegate
    
    // getInnerRadius()
    // getOuterRadius()
    // getThickness()
    // setInnerRadius(inner radius) // use old outer, return (boolean) false if fail
    // setOuterRadius(outer radius) // use old inner, return (boolean) false if fail
    // setThickness(thickness) // use old inner, return (boolean) false if fail
    // computeArea()
    // toString() "Donut(inner radius,outer radius)"
}

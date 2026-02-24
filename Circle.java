
/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle
{

    private double radius;
    private String color;

    public Circle() {
        radius = 1.0;
        color = "red";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "Circle [radius=" + radius + ", color=" + color + "]";
    }
}
class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super();
        height = 1.0;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height; 
    }
    
    public String toString() {
        return "Cylinder [radius=" + getRadius() + ", color=" + getColor() + ", height=" + height + "]";
    }
}
class TestCircleCylinder {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.5, "blue");

        System.out.println(circle1);
        System.out.println("Area: " + circle1.getArea());

        System.out.println(circle2);
        System.out.println("Area: " + circle2.getArea());

        Cylinder cylinder1 = new Cylinder();
        Cylinder cylinder2 = new Cylinder(3.0, "green", 5.0);

        System.out.println("Volume: " + cylinder2.getVolume());
        Circle circleRef = cylinder2;
        System.out.println("\nUpcasting: " + circleRef);
        System.out.println("Area from upcasted reference: " + circleRef.getArea());

        if (circleRef instanceof Cylinder) {
            Cylinder cylRef = (Cylinder) circleRef; // safe downcast
            System.out.println("Downcasted volume: " + cylRef.getVolume());
        }
    }
}

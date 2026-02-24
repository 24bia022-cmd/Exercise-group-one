
/**
 * Write a description of class Point here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Point
{
    private double x;
    private double y;

    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] getXY() {
        return new double[]{x, y};
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
class MovablePoint extends Point {
    private double xSpeed;
    private double ySpeed;

    public MovablePoint() {
        super();
        this.xSpeed = 0.0;
        this.ySpeed = 0.0;
    }

    public MovablePoint(double xSpeed, double ySpeed) {
        super();
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    
    public MovablePoint(double x, double y, double xSpeed, double ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double getXSpeed() {
        return xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public double[] getSpeed() {
        return new double[]{xSpeed, ySpeed};
    }

    public void move() {
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }

    public String toString() {
        return super.toString() + " speed=(" + xSpeed + ", " + ySpeed + ")";
    }
}
class Lab3_PointMovablePoint {
    public static void main(String[] args) {
        Point p1 = new Point(2.0, 3.0);
        System.out.println("Point: " + p1);

        MovablePoint mp1 = new MovablePoint(1.0, 2.0, 0.5, 0.5);
        System.out.println("Before move: " + mp1);

        mp1.move();
        System.out.println("After move: " + mp1);

        mp1.move();
        System.out.println("After move again: " + mp1);
    }
}




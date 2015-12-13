package week04;

/**
 * Created by georgipavlov on 11.12.15.
 */
public class Point {
    private   final double x;
    private   final double y;
    private  Point pointCopy;
    private static final int ORIGIN=0;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(double y, double x) {
        this.y = y;
        this.x = x;
    }

    public Point(Point p){
        this.y=p.getY();
        this.x=p.getX();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (Double.compare(point.getX(), getX()) != 0) return false;
        return Double.compare(point.getY(), getY()) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public LineSegment Add(Point point1, Point point2){
        LineSegment lineSegment = new LineSegment(point1,point2);
        return lineSegment;
    }


}

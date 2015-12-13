package week04;

/**
 * Created by georgipavlov on 12.12.15.
 */
public class Circle implements Shape{
    private final double r;

    public Circle(double r) {
        this.r = Math.abs(r);
    }

    public double getR() {
        return r;
    }

    public Circle(Circle c){
        r=this.getR();
    }

    public Point getUpperV(){
        return  new Point(0,r);
    }

    public Point getRightV(){
        return  new Point(r,0);
    }


    public Point getLeftV(){
        return  new Point(-r,0);
    }

    public Point getLowerV(){return  new Point(0,-r);}


    public Point getCenter(){
        return new Point(0,0);
    }

    @Override
    public double getPerimeter(){
        return 3.14*2*r;
    }

    @Override
    public double getArea(){
        return 3.14*Math.pow(r,2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.getR(), getR()) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getR());
        return (int) (temp ^ (temp >>> 32));
    }


    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }
}

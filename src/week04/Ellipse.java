package week04;

/**
 * Created by georgipavlov on 12.12.15.
 */
public class Ellipse  implements  Shape{
    private final double max;
    private final double min;

    public Ellipse(double max, double min) {
        if(max == 0 || min == 0){
            System.out.println("they are on the 0");
            this.max =0;
            this.min = 0;
        }else {
            this.max = Math.abs(max);
            this.min = Math.abs(min);
        }
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public Ellipse(Ellipse ellipse){
        this.min = ellipse.getMin();
        this.max = ellipse.getMax();
    }


    public Point getUpper(){
        return  new Point(0,min);
    }

    public Point getRightV(){
        return  new Point(max,0);
    }

    public Point getLeftV(){return  new Point(-max,0);}

    public Point getLowerV(){
        return  new Point(0,-min);
    }

    public Point getCenter(){
        return new Point(0,0);
    }

    @Override
    public double getPerimeter(){
        return 3.14*(3*(min+max) -
                Math.sqrt((3*min + max)*(3*max + min)));
    }

    @Override
    public double getArea(){
        return 3.14*max*min;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;

        Ellipse ellipse = (Ellipse) o;

        if (Double.compare(ellipse.getMax(), getMax()) != 0) return false;
        return Double.compare(ellipse.getMin(), getMin()) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getMax());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMin());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "x= " + max +
                ", y= " + min +
                '}' + " height "+ min*2 + " width " + max*2;
    }
}

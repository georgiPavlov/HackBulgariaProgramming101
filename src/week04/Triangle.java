package week04;

/**
 * Created by georgipavlov on 12.12.15.
 */
public class Triangle {
    private final Point poin1;
    private final Point poin2;
    private final Point poin3;


    public Triangle(Point poin1, Point poin2, Point poin3) {
        if((poin1.getX() == poin2.getX() && poin1.getX() == poin3.getX() )||
                (poin1.getY() == poin2.getY() && poin1.getY() == poin3.getY())){
            System.out.println("On same line error");
            this.poin1 = null;
            this.poin2 = null;
            this.poin3 = null;

        }else {
            this.poin1 = poin1;
            this.poin2 = poin2;
            this.poin3 = poin3;
        }
    }

    public Point getPoin1() {
        return poin1;
    }

    public Point getPoin2() {
        return poin2;
    }

    public Point getPoin3() {
        return poin3;
    }


    public LineSegment getSegment1(){
        return new LineSegment(poin1, poin2);
    }

    public LineSegment getSegment2(){
        return new LineSegment(poin1, poin3);
    }

    public LineSegment getSegment3(){
        return new LineSegment(poin2, poin3);
    }

    public double getBase(){
        return getSegment1().getLength();
    }

    public  double getHeight(){
        double m = getBase();
        double b = poin1.getY() - m*poin1.getX();
        double height = m*poin3.getX() - poin3.getY() + b;
        return height;
    }

    public Point center(){
        double xM = (getPoin1().getX() + getPoin2().getX())/2;
        double yM = (getPoin1().getY() + getPoin2().getY())/2;
        double xG = (2*xM + poin3.getX())/3;
        double yG = (2*yM + poin3.getY())/3;
        return  new Point(yM,xM);
    }

    public double getPerimeter(){
        return getSegment1().getLength() + getSegment2().getLength()
                + getSegment3().getLength();
    }

    public double getArea(){
        return (getBase()*getHeight())/2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        if (!getPoin1().equals(triangle.getPoin1())) return false;
        if (!getPoin2().equals(triangle.getPoin2())) return false;
        return getPoin3().equals(triangle.getPoin3());

    }

    @Override
    public int hashCode() {
        int result = getPoin1().hashCode();
        result = 31 * result + getPoin2().hashCode();
        result = 31 * result + getPoin3().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" + getSegment1().toString() + " " +
                getSegment2().toString() + " " +
                getSegment3().toString() + " " +'}' + " base " +
                getBase() + " height " + getHeight();
    }
}

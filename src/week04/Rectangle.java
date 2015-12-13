package week04;

/**
 * Created by georgipavlov on 11.12.15.
 */
public class Rectangle implements Shape {
   private Point getUpperLeft;
   private Point getLowerRight;

    public Rectangle(Point getUpperLeft, Point getLowerRight) throws Exception {
        if(getLowerRight.getX() == getUpperLeft.getX() ||
                getLowerRight.getY() == getUpperLeft.getY() ){
            System.out.println("error");
            throw new Exception();
        }else {
        this.getUpperLeft = getUpperLeft;
        this.getLowerRight = getLowerRight;
        }
    }

    public Rectangle(Rectangle t){
        getUpperLeft = t.getUpperLeftV();
        getLowerRight = t.getLowerRightV();
    }

    public Point getUpperLeftV(){
        getUpperLeft.toString();
        return  getUpperLeft;

    }

    public Point getUpperRightV(){
        Point point = new Point(getUpperLeft.getY(), getLowerRight.getX());
        point.toString();
        return  point;
    }


    public Point getLowerLeftV(){
       Point point = new Point(getLowerRight.getY(),getUpperLeft.getX());
        point.toString();
        return point;


    }

    public Point getLowerRightV(){
        getLowerRight.toString();
        return getLowerRight;
    }

    public void getUpper(){
        System.out.println(new LineSegment(getUpperLeftV(),getUpperRightV()));
    }

    public void getRight(){
        System.out.println(new LineSegment(getUpperRightV(),getLowerRightV()));

    }

    public void getLower(){
        System.out.println(new LineSegment(getLowerLeftV(),getLowerRightV()));
    }

    public  void getLeft(){
        System.out.println(new LineSegment(getUpperLeftV(),getLowerLeftV()));
    }

    public double width(){
        double result = Math.abs(getLowerRightV().getX() - getLowerLeftV().getX());
        return result;
    }

    public double height (){
        double result = Math.abs(getLowerRightV().getY() - getUpperRightV().getY());
        return result;
    }


    public Point center(){
        double xM = (getLowerRight.getX() + getUpperLeft.getX())/2;
        double yM = (getLowerRight.getY() + getUpperLeft.getY())/2;
        return new Point(yM,xM);
    }

    @Override
    public double getPerimeter(){
         return width()*2 + height()*2;
     }

    @Override
    public double getArea(){
        return  width()*height();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;

        Rectangle rectangle = (Rectangle) o;

        if (!getUpperLeft.equals(rectangle.getUpperLeft)) return false;
        return getLowerRight.equals(rectangle.getLowerRight);

    }

    @Override
    public int hashCode() {
        int result = getUpperLeft.hashCode();
        result = 31 * result + getLowerRight.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "getUpperLeft=" + getUpperLeft +
                ", getLowerRight=" + getLowerRight +
                '}' + " height " + height() + " width " + width();
    }
}

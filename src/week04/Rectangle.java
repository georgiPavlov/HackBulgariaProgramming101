package week04;

/**
 * Created by georgipavlov on 11.12.15.
 */
public class Rectangle {
   private Point getUpperLeft;
   private Point getLowerRight;

    public Rectangle(Point getUpperLeft, Point getLowerRight) {
        if(getLowerRight.getX() == getUpperLeft.getX() ||
                getLowerRight.getY() == getUpperLeft.getY() ){
            System.out.println("error");
        }else {
        this.getUpperLeft = getUpperLeft;
        this.getLowerRight = getLowerRight;
        }
    }

    public Point getUpperLeftV(){
        getUpperLeft.toString();
        return  getUpperLeft;

    }

    public Point getUpperRightV(){
        Point point = new Point(getUpperLeft.getX(), getLowerRight.getY());
        point.toString();
        return  point;
    }


    public Point getLowerLeftV(){
       Point point = new Point(getLowerRight.getX(),getUpperLeft.getY());
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
        double x = width()/2;
        double y = height()/2;
        return new Point(y,x);
    }

     public double getPerimeter(){

     }








}

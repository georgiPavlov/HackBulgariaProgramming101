package week04;

/**
 * Created by georgipavlov on 11.12.15.
 */
public class LineSegment implements Comparable<LineSegment> {
    private final Point xPoint;
    private final Point yPoint;

    public LineSegment(Point x, Point y) {
        if(!x.equals(y)) {
            this.xPoint = x;
            this.yPoint = y;
        }else {
            System.out.println("they are not equal");
            this.xPoint = null;
            this.yPoint = null;
        }
    }

    public Point getxPoint() {
        return xPoint;
    }

    public Point getyPoint() {
        return yPoint;
    }

    public LineSegment(LineSegment lineSegment){
         xPoint = lineSegment.getxPoint();
         yPoint = lineSegment.getyPoint();
     }

    public double getLength(){
        double positionX = Math.abs(xPoint.getX() - yPoint.getX());
        double positionY  =  Math.abs(xPoint.getY() - yPoint.getY());
        double result = Math.pow(positionX,2) + Math.pow(positionY,2);
        return Math.pow(result,0.5);
    }

    @Override
    public String toString() {
        return String.format("Line[( %.2f , %.2f), ( %.2f, %.2f)" ,
                xPoint.getX(),xPoint.getY(),yPoint.getX(),yPoint.getY());
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 23 + xPoint.hashCode();
        hash = hash * 23 + yPoint.hashCode();
        return hash;
    }


    @Override
    public int compareTo(LineSegment o) {
        double a = getLength();
        if(a > o.getLength()){
            return 1;

        }else if(a < o.getLength()){
            return  -1;
        }
        return 0;
    }


}

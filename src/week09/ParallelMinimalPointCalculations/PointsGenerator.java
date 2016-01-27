package week09.ParallelMinimalPointCalculations;

import java.util.*;

/**
 * Created by georgipavlov on 27.01.16.
 */
public class PointsGenerator {
    private List<Point> points;
    private static final int HOW_MANY_POINTS  = 100_000;
    private Random random;

    public PointsGenerator(){
        random = new Random();
        points = new ArrayList<>();
    }


    public void generatePoints(){
        int x;
        int y;
        for (int i = 0; i <HOW_MANY_POINTS; i++) {
            x= random.nextInt(10_001);
            y= random.nextInt(10_001);
            points.add(new Point(x,y));
        }
    }

    Map<Point,Point> getNearestPoints(List<Point> generatedPoints){
        Point getPoint;
        Point temp;
        Point result = null;
        double lenght;
        Double lenTemp = null;
        Map<Point,Point> map = new Hashtable<>();
        for (int i = 0; i < points.size() ; i++) {
            getPoint = points.get(i);
            p:for (int j = 0; j <points.size(); j++) {
                temp = points.get(j);
                if(j == i){
                    continue p;
                }
                if (temp.getX() == getPoint.getX()){
                    lenght = Math.abs(getPoint.getX() - temp.getX());
                }else if(temp.getY() == getPoint.getY()){
                    lenght = Math.abs(getPoint.getX() - temp.getX());
                }else {
                    lenght = triangleCalc(getPoint,temp);
                }

                if(lenTemp == null){
                    lenTemp = lenght;
                    result = temp;
                }else if(lenTemp > lenght) {
                    lenTemp = lenght;
                    result = temp;
                }
            }
            lenTemp =null;
            map.put(getPoint,result);
        }
        return map;
    }

    private double triangleCalc(Point getPoint,Point temp){
        Point newPoint = new Point(temp.getX(),getPoint.getY());
        int xLength = getPoint.getX() - newPoint.getX();
        int yLength = temp.getY() - newPoint.getY();
        return Math.sqrt(Math.pow(xLength,2) + Math.pow(yLength,2));
    }


}

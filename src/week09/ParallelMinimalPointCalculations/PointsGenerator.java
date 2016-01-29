package week09.ParallelMinimalPointCalculations;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by georgipavlov on 27.01.16.
 */
public class PointsGenerator implements Runnable{
    private static List<Point> points =  new ArrayList<>();
    int index = 0;
    private static final int HOW_MANY_POINTS  = 100_000;
    static Map<Point,Point> map =  new HashMap<>();
    static Lock lock = new ReentrantLock();

    public static void generatePoints(){
        Random random = new Random();
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


    public  synchronized void  doCalculations(List<Point> inPoints, int indexFrom,
                               int indexTo, Map<Point, Point> outMap){
        Point getPoint;
        Point temp;
        Point result = null;
        double lenght;
        Double lenTemp = null;
        map = new Hashtable<>();
        for (int i = indexFrom; i < indexTo ; i++) {
                getPoint = inPoints.get(i);
                p:for (int j = 0; j <inPoints.size(); j++) {
                    temp = inPoints.get(j);
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
                if(!lock.tryLock()){
                    lock.lock();
                map.put(getPoint,result);
                    lock.unlock();
                }

        }
    }


    @Override
    public void run() {
        doCalculations(points,index,index + points.size()/2,map);
    }

    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();
        PointsGenerator.generatePoints();
         PointsGenerator p1= new PointsGenerator();
        PointsGenerator p2= new PointsGenerator();
        Thread thread1 =new Thread(p1);
        Thread thread2 =new Thread(p2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Time: " +  (System.currentTimeMillis() - time)) ;
    }
}

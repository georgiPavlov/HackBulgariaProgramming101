package week09.ParallelMinimalPointCalculations;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by georgipavlov on 27.01.16.
 */
public class PointsGenerator implements Runnable{
    private static List<Point> points =  new ArrayList<>();
    int index = 0;
    private static final int HOW_MANY_POINTS  = 1000;
    static Map<Point,Point> map;
    static Lock lock;

    public PointsGenerator(int index){
        this.index = index;
        if(map == null){
            map = new ConcurrentHashMap<>();
        }
        if(lock == null){
            lock =new ReentrantLock();
        }
    }

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


    public  void  doCalculations(List<Point> inPoints, int indexFrom,
                               int indexTo, Map<Point, Point> map){
        Point getPoint;
        Point temp;
        Point result = null;
        double lenght;
        Double lenTemp = null;
        for (int i = indexFrom; i < indexTo ; i++) {
                getPoint = inPoints.get(i);
            System.out.println("out LOOP " +i);
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
                    //System.out.println("Inner loop " + j);

                }
                lenTemp =null;

            map.put(getPoint,result);

        }

    }

    public static void printMap(){
        for (Map.Entry<Point, Point> entry : map.entrySet())
        {
            System.out.println(entry.getKey().getX()+":" + entry.getKey().getY()  + "/" +
                    entry.getValue().getX()+":"+ entry.getValue().getY());
        }
    }


    @Override
    public void run() {
        doCalculations(points, index , (HOW_MANY_POINTS/2)+ index,map);
    }

    public static void main(String[] args) throws InterruptedException {
        double time = System.currentTimeMillis();
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores + ": cores ");
        PointsGenerator.generatePoints();
         PointsGenerator p1= new PointsGenerator(0);
        PointsGenerator p2= new PointsGenerator(HOW_MANY_POINTS/2);
        Thread thread1 =new Thread(p1);
        Thread thread2 =new Thread(p2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Time: " +  ((System.currentTimeMillis() - time)/1000)/60) ;
        printMap();
    }
}

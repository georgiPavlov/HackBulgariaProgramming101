package week03.FridayToDoList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by georgipavlov on 05.12.15.
 */
public class ToDoList implements ToDoInterface {

    private Set<Task> set;
    private double hours;



    public ToDoList(double hours) {
        this.hours = hours;
        set = new TreeSet<>(TComparator);
    }

    @Override
    public void addTask(Task t) {
        set.add(t);

    }

    @Override
    public void markFinished(Task t) {
       set.remove(t);
    }

    @Override
    public void markCancelled(Task t) {
       set.remove(t);
    }

    @Override
    public Task getTop() {
        Iterator<Task> it = set.iterator();
        Task current ;
        current = it.next();
        return current;
    }

    @Override
    public boolean canFinish() {
        Iterator<Task> it = set.iterator();
        double t=0;
        while (it.hasNext()){
          t += it.next().getTime();
        }
        double remaining =getRemainigTime();
        remaining -=t;
        if(remaining < 0){
            return false;
        }
        return true;
    }

    @Override
    public double getRemainigTime() {
        double t =getTimeNeeded();
        return hours-t;
    }

    @Override
    public double getTimeNeeded() {
        Iterator<Task> it = set.iterator();
        double t=0;
        while (true){
            t += it.next().getTime();
            if(!it.hasNext()){
                break;
            }
        }
        return t;
    }

    Comparator<Task> TComparator =
            new Comparator<Task>(){
                @Override
                public int compare(Task o1, Task o2) {
                   final String maximum="maximum";
                    final String defaultP = "default";
                    if(o1.getPriority().equals(maximum) && o2.getPriority().equals(defaultP)){
                        return -1;
                    }else if(o1.getPriority().equals(defaultP) && o2.getPriority().equals(maximum)) {
                        return 1;
                    }else {
                        int a=(int)o1.getName().charAt(0);
                        int b=(int)o2.getName().charAt(0);
                        if(a<b){
                            return -1;
                        }else if(a>b) {
                            return 1;
                        }else {
                            double aa=o1.getTime();
                            double bb=o2.getTime();
                            if(aa<bb){
                                return -1;
                            }else if(aa>bb) {
                                return 1;
                            } else if(o1.equals(o2)){
                                return 0;
                            }
                        }
                    }
                    return 1;

                }
            };


}

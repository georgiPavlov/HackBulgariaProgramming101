package week03.FridayToDoList;

/**
 * Created by georgipavlov on 05.12.15.
 */
public interface ToDoInterface {
    void addTask(Task t);
    void markFinished(Task t);
    void markCancelled(Task t);
    Task getTop();
    boolean canFinish();
    double getRemainigTime();
     double getTimeNeeded();

}

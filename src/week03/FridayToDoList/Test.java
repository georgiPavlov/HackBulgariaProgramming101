package week03.FridayToDoList;

/**
 * Created by georgipavlov on 05.12.15.
 */
public class Test {
    public static void main(String[] args) {
        ToDoList todo = new ToDoList(11); //11 hours remaining!
        todo.addTask(new GoOutTask(1.5f));  //default priority, smaller than 10
        todo.addTask(new SleepTask()); //straight 8 hours, of course!
        todo.addTask(new GoOutTask(2));  //default priority, smaller than 10
        todo.addTask(new GoOutTask(6));
        Task t = new GoOutTask(6);
        todo.markCancelled(t);

        if (todo.canFinish()){
            System.out.println("Woohoo!");
        } else {
            System.out.println("I am ...screwed :(");
        }

        System.out.println(todo.getTop()); //StudyForAlgebraTask
        System.out.println(todo.getTimeNeeded()); //sum of the time needed for every task added in todo list
    }
}

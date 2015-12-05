package week03.FridayToDoList;

/**
 * Created by georgipavlov on 05.12.15.
 */
public class Task {
    protected final String name;
    protected final String priority;
    protected final  double time;

    public Task(String name, String priority, double time) {
        this.name = name;
        this.priority = priority;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public double getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (Double.compare(task.getTime(), getTime()) != 0) return false;
        if (getName() != null ? !getName().equals(task.getName()) : task.getName() != null) return false;
        return !(getPriority() != null ? !getPriority().equals(task.getPriority()) : task.getPriority() != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPriority() != null ? getPriority().hashCode() : 0);
        temp = Double.doubleToLongBits(getTime());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

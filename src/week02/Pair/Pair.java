package week02.Pair;

/**
 * Created by georgipavlov on 25.11.15.
 */
public class Pair {
    Object first;
    Object second;


    public Pair(Object one,Object two){
        this.first=one;
        this.second=two;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;

        Pair pair = (Pair) o;

        if (!first.equals(pair.first)) return false;
        return second.equals(pair.second);

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}

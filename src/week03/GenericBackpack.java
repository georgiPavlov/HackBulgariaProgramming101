package week03;

/**
 * Created by georgipavlov on 30.11.15.
 */
public class GenericBackpack <T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        GenericBackpack<Integer> Int = new GenericBackpack<>();
        Int.setData(5);
        System.out.println(Int.getData());
        GenericBackpack<String> stringPack = new GenericBackpack<>();
        stringPack.setData("Hello");
        System.out.println(stringPack.getData());
    }
}

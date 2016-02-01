package week09.ParallelCopyP;

/**
 * Created by georgipavlov on 01.02.16.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(ParallelCopy.createParallelCopy("/home/georgipavlov/Downloads/Нова папка" ,
                "/home/georgipavlov/Downloads/Ruby"));
        thread.start();

    }
}

package week10.AdvancedFileSearch;

import week10.AdvancedFileSearch.FileSearch;

/**
 * Created by georgipavlov on 01.02.16.
 */
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(FileSearch.createParallelCopy("/home/georgipavlov/Downloads/Нова папка" ,
                "/home/georgipavlov/Downloads/Ruby"));
        thread.start();

    }
}

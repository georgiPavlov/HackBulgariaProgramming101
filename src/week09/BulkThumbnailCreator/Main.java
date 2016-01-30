package week09.BulkThumbnailCreator;

import java.util.ArrayList;

/**
 * Created by georgipavlov on 30.01.16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        double time  = System.currentTimeMillis();
        String linkIn =null;
        ArrayList<String> argsIn= new ArrayList<>();
        for (String s: args) {
            System.out.println(s);
            argsIn.add(s);
        }
        switch (args.length){
            case 3:{
                DataBase.widht = Integer.parseInt(argsIn.get(1));
                DataBase.height = Integer.parseInt(argsIn.get(2));
                linkIn = argsIn.get(0);
                break;
            }
            case 4:{
                DataBase.widht = Integer.parseInt(argsIn.get(2));
                DataBase.height = Integer.parseInt(argsIn.get(3));
                linkIn = argsIn.get(1);
                BulkThumbnail.recursive = true;
                break;
            }
        }
        Thread thread = new Thread(new BulkThumbnail(linkIn));
        thread.start();
        thread.join();
        System.out.println("finish in " + (System.currentTimeMillis() - time));

    }
}

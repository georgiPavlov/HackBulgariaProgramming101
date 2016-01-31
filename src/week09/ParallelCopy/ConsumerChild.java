package week09.ParallelCopy;

/**
 * Created by georgipavlov on 31.01.16.
 */
public class ConsumerChild implements Runnable{
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop){

        }

    }
}

package week10.MeasurementTool;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class ConsumerT<T> implements Runnable {
    private boolean loop=true;
    DB<T> dataBase;
    T element;

    public boolean isLoop() {
        return loop;
    }

    public ConsumerT(DB<T> dataBase){
        this.dataBase = dataBase;
    }

    public void setLoop(boolean loop,T element) {
        this.loop = loop;
        this.element = element;
    }

    @Override
    public void run() {
        while (!(dataBase.getCountConsumers().addAndGet(0) == dataBase.getMaxElements())){
            //System.out.println("consuming...");
            consume();
        }
        System.out.println("out consumer");
        dataBase.isFinishConsumers= true;
        dataBase.finishConsuming.getAndIncrement();
        System.out.println(dataBase.isFinishConsumers);
    }

    private void consume() {
        while (dataBase.getQueueT().size() == 0){
            try {
                while (dataBase.queueT.size() == 0){
                    if(dataBase.isFinishConsumers == true){
                        return;
                    }
                synchronized (dataBase){
                dataBase.wait();
                }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dataBase.queueT.poll();
        //System.out.println("Consumer consumer element ");
        dataBase.countConsumers.getAndIncrement();
    }

}

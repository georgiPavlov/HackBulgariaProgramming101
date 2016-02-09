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
        while (!(dataBase.getCountConsumers().addAndGet(0) >= dataBase.getMaxElements())){
            //System.out.println("consuming...");
            consume();
        }
       // System.out.println("out consumer");
      //  dataBase.isFinishConsumers= true;
       // System.out.println(dataBase.isFinishConsumers);
        dataBase.finishConsuming.getAndIncrement();
         //System.out.println("out consumer");
    }

    private void consume() {
        while (dataBase.queueT.isEmpty() &&
                (!(dataBase.finishProducing.getAndAdd(0) >= dataBase.produserCount))){
            try {
                synchronized (dataBase){
                  //  System.out.println("wait consumer" + dataBase.finishProducing.getAndAdd(0) + dataBase.produserCount);
                    dataBase.wait();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(dataBase.finishProducing.getAndAdd(0) >=  dataBase.produserCount
                && dataBase.queueT.isEmpty()  ){
            return;
        }
        dataBase.queueT.poll();
        synchronized (dataBase.queueT){
            dataBase.queueT.notifyAll();
        }
        //System.out.println("Consumer consumer element ");
        dataBase.countConsumers.getAndIncrement();
    }

}

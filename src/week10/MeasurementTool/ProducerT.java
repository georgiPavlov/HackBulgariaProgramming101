package week10.MeasurementTool;

/**
 * Created by georgipavlov on 03.02.16.
 */
public class ProducerT<T> implements Runnable {
    private boolean loop=true;
    DB<T> dataBase;
    T element;

    public boolean isLoop() {
        return loop;
    }

    public ProducerT(DB<T> dataBase,T element){
        this.dataBase = dataBase;
        this.element = element;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;

    }

    @Override
    public void run() {
       // System.out.println("start produer");
        while (!(dataBase.getCountProdusers().addAndGet(0) == dataBase.getMaxElements())){
            //System.out.println("producing...");
            produce();
        }
        System.out.println("out producer");
        dataBase.finishProducers = true;
        dataBase.finishProducing.getAndIncrement();
        //System.out.println(dataBase.finishProducers);
    }

    private void produce() {
        if(dataBase.finishProducers){
            return;
        }
        dataBase.queueT.add(element);
       // System.out.println("Produse added element");
        dataBase.countProducers.getAndIncrement();
        synchronized (dataBase){
            dataBase.notifyAll();
        }
    }
}

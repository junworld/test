package concurrent.executors;

public class LongTimeTask implements Runnable {

    private int num;

    public LongTimeTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("这是第"+num+"个线程");
        try {
            Thread.sleep(1000L);
            System.out.println("这是第"+num+"个线程END");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

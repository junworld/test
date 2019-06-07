package concurrent.waitNotify;

/**
 * 需要上厕所的人
 */
public class ShitTask implements Runnable {

    private Washroom washroom;

    private String name;

    public ShitTask(Washroom washroom, String name) {
        this.washroom = washroom;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (washroom.getLock()) {
            System.out.println(name + "获取了厕所的锁");
            //如果厕所一直不可用，则一直进行while循环 不进行下面的逻辑，等待notify后继while下面的逻辑
            while (!washroom.isAvailable()) {
                try {
                    washroom.getLock().wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + "上完了厕所");
        }
    }
}

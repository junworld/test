package concurrent;

public class ThreadStateDemo {
    private static Object lock = new Object();  //锁对象

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                double d = 0.1;
                int i = 0;
                while (i++ < 100000) {  //模仿一个耗时操作
                    d = d*0.3d;
                }
                LockUtil.sleep(2000L);    //休眠2秒钟
                synchronized (lock) {
                    LockUtil.wait(lock);
                }
                synchronized (lock) {   //尝试获取lock锁

                }
            }
        }, "t");

        System.out.println("初始状态：" + t.getState());
        t.start();
        System.out.println("运行一个耗时操作时的状态：" + t.getState());
        LockUtil.sleep(1000L);
        System.out.println("休眠时的状态：" + t.getState());
        LockUtil.sleep(2000L);
        System.out.println("wait的状态：" + t.getState());
        synchronized (lock) {
            lock.notifyAll();
        }
        System.out.println("被notify后的状态：" + t.getState());
        synchronized (lock) {
            LockUtil.sleep(1000L); //调用sleep方法不会释放锁
            System.out.println("因为获取锁而阻塞的状态：" + t.getState());
        }
    }
}

class LockUtil {
    public static void sleep(long mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void wait(Object obj) {
        try {
            obj.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
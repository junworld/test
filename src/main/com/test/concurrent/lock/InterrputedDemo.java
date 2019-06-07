package concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterrputedDemo {

    public static void main(String[] args) throws Exception {
        final Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();    //先获取锁
                try {
                    System.out.println("t1线程获得了锁");
                    try {
                        Thread.sleep(5000L);    //获取锁之后就休眠
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } finally {
                    System.out.println("t1释放锁");
                    lock.unlock();
                }
            }
        }, "t1");
        t1.start();

        Thread.sleep(1000L);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();   //可中断的锁
                    try {
                        System.out.println("t2线程获得了锁");
                    } finally {
                        System.out.println("t2释放锁");
                        lock.unlock();
                    }
                } catch (InterruptedException e) {
                    System.out.println("别的线程发送了中断信号，lockInterruptibly立即返回并且抛出异常，这里是处理异常的代码");
                }
            }
        }, "t2");
        t2.start();

        Thread.sleep(1000L);

        t2.interrupt();
    }



}

package concurrent;

public class TestTread {

    public static void main(String[] args) {
        /**
         * 控制台输出结果：
         * 主线程ID是： 1
         * 名称线程2的线程ID是：1
         * 名称线程1的线程ID是：11
         * 结论：
         * 1、主线程和线程2的线程ID相同，说明直接调用run()方法不会创建新的线程，而是在主线程中直接调用run()方法，普通的方法调用
         * 2、线程1先调用start()方法，而后线程2调用run()方法，最终却线程2先于线程1输出，说明新建的线程并不会影响主线程的执行顺序
         */
        System.out.println("主线程ID是： " + Thread.currentThread().getId());
        Thread t1 = new MyThread("线程1");
        Thread t2 = new MyThread("线程2");
        t1.start();
        t2.run();
    }
}

class MyThread extends Thread {
    private String name;
    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("名称" + name + "的线程ID是：" + Thread.currentThread().getId());
    }

}
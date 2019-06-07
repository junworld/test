package concurrent.waitNotify;

/**
 * 了解多线程中的wait和notify原理，公众号文章下面链接
 * https://mp.weixin.qq.com/s?__biz=MzIxNTQ3NDMzMw==&mid=2247484153&idx=1&sn=eccbe54a1df23d81ad525f0dcce65f64&scene=19#wechat_redirect
 * 也可到印象笔记中查看搜索关键字wait，notify
 */
public class TestStart {

    public static void main(String[] args) {
        Washroom washroom = new Washroom();

        new Thread(new ShitTask(washroom,"狗哥"), "BROTHER-DOG-THREAD").start();
        new Thread(new ShitTask(washroom,"猫爷"), "GRANDPA-CAT-THREAD").start();
        new Thread(new ShitTask(washroom,"王妮妹"), "WANG-NI-MEI-THREAD").start();
        //故意休眠时间，之前先获取锁也要等到notify才能进行下面的逻辑
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(new RepairTask(washroom), "REPAIR-thread").start();

    }
}

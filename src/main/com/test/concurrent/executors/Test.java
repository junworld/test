package concurrent.executors;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(
                1,//基本大小
                1,//最大大小
                10,//线程最大存活时间，为0表示线程不会因为长时间空闲而停止
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2),//大小为1的阻塞队列
                new MyThreadFactory(),//自定义线程
                new ThreadPoolExecutor.AbortPolicy()//饱和策略
        );

        //ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            service.submit(new LongTimeTask(1));
            service.submit(new LongTimeTask(2));
            service.submit(new LongTimeTask(3));
            //service.shutdown();
            //service.shutdown();
            service.isTerminated();
            service.awaitTermination(10, TimeUnit.SECONDS);
            //System.out.println(service.isShutdown());
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));
            service.submit(new LongTimeTask(4));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

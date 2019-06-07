package concurrent.executors;

public class ScheduleDemo {

    private static class PrintTask implements Runnable {

        private String s;

        public PrintTask(String s) {
            this.s = s;
        }
        @Override
        public void run() {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        /*//固定线程数量的线程池的意思是：最开始该线程池中的线程数为0，之后每提交一个任务就会创建一个线程，直到线程数等于指定的nThreads参数，此后线程数量将不再变化
        ExecutorService executorService1 = Executors.newFixedThreadPool(20);
        //可缓存的意思是：会为每个任务都分配一个线程，但是如果一个线程执行完任务后长时间(60秒)没有新的任务可执行，该线程将被回收
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        //通过此方法可以创建单线程的线程池
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();
        //通过此方法可以创建固定线程数量的线程池，而且以延迟或定时的方式来执行任务
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);*/

        //ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        //隔1秒后打印
        //service.schedule(new PrintTask("1"), 1, TimeUnit.SECONDS);

        //首次5秒后打印，每隔1秒打印一次
        //service.scheduleAtFixedRate(new PrintTask("2"), 5, 1, TimeUnit.SECONDS);

        AddTask addTask = new AddTask(1, 2);
        Thread thread = new Thread(addTask);
        thread.start();
    }

    static class AddTask implements Runnable {
        private int i;

        private int j;

        public AddTask(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void run() {
            int sum = i+j;
            System.out.println("线程t运行结果：" + sum);
        }
    }

}

package concurrent.executors;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

    private static int COUNTER = 0;

    private static String THREAD_PREFIX = "myThread";

    @Override
    public Thread newThread(Runnable r) {
        int i = COUNTER++;
        return new Thread(r, THREAD_PREFIX + i);
    }
}

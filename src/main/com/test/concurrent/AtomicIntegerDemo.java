package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println("初始值" + atomicInteger.get());

        System.out.println("自增的值" + atomicInteger.incrementAndGet());

        boolean result = atomicInteger.compareAndSet(2, 10);

        System.out.println("automicInteger比较成功了吗 "+result+" atomicInteger最后的值为"+atomicInteger.get());
    }
}

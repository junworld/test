package concurrent.executors;
import java.util.concurrent.*;

/**
 * Callable是实现有返回值多线程的方式
 */
class AddTask implements Callable<Integer> {

    private int i;

    private int j;

    public AddTask(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Integer call() throws Exception {
        int sum = i+j;
        return sum;
    }
}


public class CallableTest {

    public static void main(String[] args) {
        AddTask task = new AddTask(1, 2);
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future = service.submit(task);
        try {
            int result = future.get();
            System.out.println("线程main运行的结果：" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}



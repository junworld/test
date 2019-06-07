package concurrent.waitNotify;

/**
 * 厕所
 */
public class Washroom {
    /**
     * 表示厕所的门是否可用状态
     */
    private volatile boolean isAvailable = false;
    /**
     * 厕所的门
     */
    private Object lock = new Object();

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Object getLock() {
        return lock;
    }
}

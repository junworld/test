package concurrent;

public class ThreadLocalDemo {

    public static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<String>(){

        @Override
        protected String initialValue(){
            return "调用initialVlaue方法初始化值";
        }
    };



    public static void main(String[] args) {
        ThreadLocalDemo.THREAD_LOCAL.set("与main相关的字符串");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //未set 会调用initialValue方法
                System.out.println("t1线程从ThreadLocal中获取的值:" + ThreadLocalDemo.THREAD_LOCAL.get());
                ThreadLocalDemo.THREAD_LOCAL.set("与t1线程相关联的字符串");
                //返回线程set的值
                System.out.println("t1线程再次从ThreadLocal中获取值:" + ThreadLocalDemo.THREAD_LOCAL.get());
            }
        },"t1").start();
        System.out.println("main 线程从ThreadLocal中获取值:" + ThreadLocalDemo.THREAD_LOCAL.get());
    }


}


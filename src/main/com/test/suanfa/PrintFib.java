package suanfa;

public class PrintFib {
    //斐波那契数列 从第3项开始，每一项等于前两项之和
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;
        System.out.print(a + "\t" + b + "\t");
        for (int i = 0; i < 10; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.print(c + "\t");
        }
    }
}

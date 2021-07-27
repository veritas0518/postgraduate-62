package Day28;

/**
 * @ClassName: ThreadTest
 * @Description: 多线程的创建：方式一：继承于thread类的方式
 * @Author: TianXing.Xue
 * @Date: 2021/7/24 14:02
 * @Version:1.0 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 **/
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }

        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i+"***main()***");
            }

        }
    }
}

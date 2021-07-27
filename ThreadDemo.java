package Day28;

/**
 * @ClassName: ThreadDemo
 * @Description: 创建两个分线程，其中一个线程遍历100以内的偶数，一个遍历100以内的奇数
 * @Author: TianXing.Xue
 * @Date: 2021/7/24 14:57
 * @Version:
 **/


public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 myThread1 = new MyThread1();
//        MyThread2 myThread2 = new MyThread2();
//        myThread1.start();
//        myThread2.start();

        //创建Thread类的匿名子类的方式
        new Thread(){
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+"+"+i);
                    }
                }
            }
        }.start();

        new Thread(){
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if (i%2!=0){
                        System.out.println(Thread.currentThread().getName()+"+"+i);
                    }
                }
            }
        }.start();
    }
}
class MyThread1 extends Thread{

}
class MyThread2 extends Thread{

}
package Day28;

/**
 * @ClassName: ThreadMethodTesr
 * @Description: 测试Thread中的常用方法
 * @Author: TianXing.Xue
 * @Date: 2021/7/24 15:30
 * @Version:1.0
 * 1.start():启动当前线程；调用当前线程的run()
 * 2.run():通常需要重写Thread类中的此方法，将创建的线程执行的操作声明在此方法当中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权，线程让步
 * 7.join(): 在线程 a中调用线程 b的join(),一旦调用完以后，线程a就进入阻塞状态，
 * 直到线程b完全执行完以后，线程a才结束阻塞状态（抢夺式）
 * 8.stop():已过时，当执行此方法时，强制结束当前线程。
 * 9.sleep(long millitime):让当前线程“睡眠”指定millitime毫秒，在指定millitime毫秒时间内。当前线程是阻塞状态
 * 10.isAlive():判断当前线程是否存活
 * <p>
 * 线程的优先级：
 * 1.MAX_PRIORITY:10
 * 2.MIN_PRIORITY:1
 * 3.NORMAL_PRIORITY:5
 * 2.如何获取和设置当前线程的优先级
 *    getPriority():获取线程的优先级
 *    setPriority():设置线程的优先级
 *
 *    说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上将，高优先级的线程高概率情况下执行，
 *    并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行
 *
 *
 *
 **/

class HelloThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(getName() + ":" + getPriority() + ":" + i);
            }
//            if(i%20==0){
//                yield();
//            }
        }
    }

    public HelloThread(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread:1");
        // h1.setName("线程一");
        //设置分线程的优先级
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        //给主线程命名

        Thread.currentThread().setName("主线程");
Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
//            if (i == 20) {
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(h1.isAlive());
    }

}

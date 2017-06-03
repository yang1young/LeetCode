package coccurent;

import java.util.InputMismatchException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 setPriority() 方法会抛出 IllegalArgumentException 异常，如果你设置的优先级不是在1-10之间。
 ID: 每个线程的独特标识。
 Name: 线程的名称。
 Priority: 线程对象的优先级。优先级别在1-10之间，1是最低级，10是最高级。
 Status: 线程的状态。在Java中，线程只能有这6种中的一种状态：
         new, runnable, blocked, waiting, time waiting, 或 terminated
 Interrupt
 isInterrupted()方法来检查线程是否被中断了



 */
public class CocTest {

    public static void main(String[] args){

        Thread t1 = new TestThread();

        Runnable r1 = new TestRunable();
        Thread t2 = new Thread(r1);
        t2.start();

        Callable<Integer> c = new TestCallable();
        FutureTask<Integer> f = new FutureTask<Integer>(c);
        Thread t3 = new Thread(f);

        try {
            f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}


//因为Thread类本身也是实现了Runnable接口，而run()方法最先是在Runnable接口中定义的方法。
class TestThread extends Thread{

    public void run(){
        //...
    }

}

class TestRunable implements Runnable{

    public void run(){
        System.out.println('f');
    }
}

//FutureTask类实际上是同时实现了Runnable和Future接口，
//由此才使得其具有Future和Runnable双重特性。通过Runnable特性，
// 可以作为Thread对象的target，而Future特性，使得其可以取得新创建线程中的call()方法的返回值。
class TestCallable implements Callable{

    public Integer call(){
        return 0;
    }
}
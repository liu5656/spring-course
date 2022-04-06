package org.example.thread;

//import sun.jvm.hotspot.runtime.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @version 1.0
 * @Author lj
 * @date 2021/7/20 10:11 上午
 * @desc
 */
public class ThreadTest {

    static private Integer num = 1;
    private static Object obj = new Object();

    public static void main(String[] args) {
        System.out.println("----------------------继承Thread测试-------------------------------");

        MyThread thread1 = new MyThread("zhagnsan");
        MyThread thread2 = new MyThread("lisi");
        MyThread thread3 = new MyThread("wangwu");

        thread1.start();
        try{
            thread1.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        thread2.start();
        thread3.start();

        System.out.println("----------------------实现Runnable接口测试-------------------------------");
        Thread runnable1 = new Thread(new MyRunnable("runable 1"));
        Thread runnable2 = new Thread(new MyRunnable("runable 2"));
        Thread runnable3 = new Thread(new MyRunnable("runable 3"));
        runnable1.start();
        runnable2.start();
        runnable3.start();

        System.out.println("----------------------实现Callable接口测试-------------------------------");
        MyCallable call = new MyCallable();
        FutureTask<String> task = new FutureTask<>(call);
        Thread call1 = new Thread(task);
        call1.start();

        try{
            System.out.println(task.get());
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("----------------------两个线程交替打印1-100-------------------------------");
        new Thread(new NumRunnable(), "线程1").start();
        new Thread(new NumRunnable(), "线程2").start();

        System.out.println("----------------------线程池测试-------------------------------");
        List<String> tasks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            tasks.add("任务" + i);
        }
        ThreadPoolExecutor pool = threadPool();
        for (String temp : tasks) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 执行了-> " + temp);
                }
            };
            pool.execute(runnable);
        }

    }

    // 继承Thread
    static public class MyThread extends Thread {
        final private String myname;

        public MyThread(String myname) {
            this.myname = myname;
        }


        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("线程：" + myname + "已经已经运行：" + i);
            }
        }
    }

    // 实现Runnable接口
    static public class MyRunnable implements Runnable {

        final String myname;
        public MyRunnable(String myname) {
            this.myname = myname;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("runnable: " + myname + "已经执行: " + i);
            }
        }
    }

    // 实现Callable接口
    static public class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "线程已经执行，这是返回的值";
        }
    }

    // wait、notiy测试，交替打印1-100
    static public class NumRunnable implements Runnable {
        @Override
        public void run() {
            while(true){
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + ":" + num++);
                    obj.notify();
                    if (num >= 6) {
                        System.out.println(Thread.currentThread().getName() + "退出了");
                        return;
                    }else {
                        try{
                            obj.wait();
                        }catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    // 线程池Executor
    static public ThreadPoolExecutor threadPool() {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(3);
        ThreadFactory factory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, queue, factory, handler);
        return pool;
    }




}

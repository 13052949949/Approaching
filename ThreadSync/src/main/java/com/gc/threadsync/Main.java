package com.gc.threadsync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
//        thread();
//        runnable();
//        threadFactory();
//        executor();
//        callable();
//        new Synchronized1Demo().runTest();
        new Synchronized2Demo().runTest();
    }

    static void thread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread started!");
            }
        });
        thread.start();
    }

    static void runnable() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with Runnable started!");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    static void threadFactory() {
        ThreadFactory factory = new ThreadFactory() {
            AtomicInteger count = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "Thread-" + count.incrementAndGet());
            }
        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " started!");
            }
        };
        Thread thread = factory.newThread(runnable);
        thread.start();
        Thread thread1 = factory.newThread(runnable);
        thread1.start();
    }

    static void executor() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread with Runnable started!");
            }
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
    }

    static void singleThreadExecutor() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    }

    //集中处理爆发任务
    static void fixedThreadExecutor() {
//        Runnable processImageRunnable = new Runnable() {
//            @Override
//            public void run() {
//                processImage();
//            }
//        };
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        List<Bitmap> bitmaps = ...
//        for (Bitmap bitmap : bitmaps) {
//            executor.execute(processImageRunnable);
//        }
//        executor.shutdown();
    }

    static void global(Runnable runnable) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 100, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        executor.execute(runnable);
    }

    //有返回值的runnable
    static void callable() {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Done!";
            }
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(callable);
        while (true) {
            if (future.isDone()) {
                try {
                    String result = future.get();
                    System.out.println("result: " + result);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

}
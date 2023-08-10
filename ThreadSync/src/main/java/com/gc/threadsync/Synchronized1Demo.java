package com.gc.threadsync;

import java.util.concurrent.atomic.AtomicBoolean;

public class Synchronized1Demo implements TestDemo {

    //每个线程自己的独立内存
    //volatile关键字开启同步性：不同的线程操作相同的变量
//    private volatile boolean running = true;

    //Atomic...   给变量附加原子性和同步性
    private AtomicBoolean running = new AtomicBoolean(true);

    private void stop() {
//        running = false;
        running.set(false);
    }

    @Override
    public void runTest() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running.get()) {

                }
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop();
    }
}

package com.gc.threadinteraction;

public class ThreadInteractionDemo implements TestDemo{

    @Override
    public void runTest() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 1_000_000; i++) {
                    if (Thread.interrupted()){
                        return;
                    }
                    if (isInterrupted()){
                        return;
                    }
                    //耗时操作
                    System.out.println("number: " + i);
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}

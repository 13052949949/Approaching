package com.gc.threadinteraction;

public class WaitDemo implements TestDemo{


    private String shareString;

    private synchronized void initString(){
        shareString = "Android";
        notifyAll();
    }

    private synchronized void printString(){
        if (shareString == null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("String:" + shareString);
    }

    @Override
    public void runTest() {

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                initString();
            }
        });
        thread2.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printString();
            }
        });
        thread1.start();
    }
}

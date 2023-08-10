package com.gc.threadsync;

public class Synchronized3Demo implements TestDemo {

    private int x;
    private int y;
    private String name;
    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    private void count(int value) {
        synchronized (monitor1) {
            x = value;
            y = value;
            synchronized (monitor2) {
                name = "";
            }
        }
    }

    private void setName(String newName) {
        synchronized (monitor2) {
            name = newName;
            synchronized (monitor1) {
                x = 0;
                y = 0;
            }
        }
    }

    @Override
    public void runTest() {
    }
}

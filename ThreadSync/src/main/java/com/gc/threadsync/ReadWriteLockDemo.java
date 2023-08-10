package com.gc.threadsync;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo implements TestDemo{

    private int x = 0;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();



    @Override
    public void runTest() {
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    }
}

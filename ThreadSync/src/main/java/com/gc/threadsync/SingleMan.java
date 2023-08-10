package com.gc.threadsync;

public class SingleMan {

    private static volatile SingleMan mInstance;

    public SingleMan() {
    }

    public static SingleMan getInstance(){
        if (mInstance == null){
            synchronized (SingleMan.class){
                if (mInstance == null){
                    mInstance = new SingleMan();
                }
            }
        }
        return mInstance;
    }

}

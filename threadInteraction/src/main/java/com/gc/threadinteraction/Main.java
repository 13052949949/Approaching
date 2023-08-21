package com.gc.threadinteraction;

public class Main {

    public static void main(String[] args) {
//        threadInteraction();
        runWait();
    }

    private static void runWait() {
        new WaitDemo().runTest();
    }

    private static void threadInteraction() {
        new ThreadInteractionDemo().runTest();
    }

}
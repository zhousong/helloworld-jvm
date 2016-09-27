package com.helloworld.stack;

/**
 * Hello world!
 */
public class ThreadStackApp {
    private static int statckLen = 1;

    public static void main(String[] args) {
        System.out.println("ThreadStack!");
        try {
            stackOverFlow();
        } catch (Throwable throwable) {
            System.out.println(throwable);
            System.out.println(statckLen);
        }

    }

    public static void stackOverFlow() {
        statckLen++;
        stackOverFlow();
    }
}

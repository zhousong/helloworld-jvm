package com.helloworld.heap;

import java.util.concurrent.TimeUnit;

/**
 * Created by helloworld on 16/9/3.
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 *   at java.lang.Thread.start0(Native Method)
 *   at java.lang.Thread.start(Thread.java:714)
 */
public class ThreadsOverflow {
    private static int threadCount = 0;

    public static void main(String[] args) {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadCount++;
                    System.out.println(threadCount);
                    try {
                        TimeUnit.HOURS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }
}

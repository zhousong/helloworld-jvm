package com.helloworld.g1;

import java.util.concurrent.TimeUnit;

/**
 * -XX:+PrintGCDetails -Xmx10m -Xms10m -XX:+UseG1GC -XX:MaxGCPauseMillis=200
 */
public class UseG1GC {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            byte [] b1 = new byte[1024 * 1024];
            byte [] b2 = new byte[1024 * 1024];
            byte [] b3 = new byte[1024 * 1024];
            TimeUnit.SECONDS.sleep(3);
        }

//        int count = 1;
//        boolean stop = false;
//        while (!stop) {
//            System.out.println("enter:" + count);
//            byte [] b1 = new byte[1024 * 1024];
//            byte [] b2 = new byte[1024 * 1024];
//            byte [] b3 = new byte[1024 * 1024];
//            if (count++ == 100) {
//                stop = true;
//            }
//            TimeUnit.SECONDS.sleep(3);
//            System.out.println("end:" + count + '\n');
//        }
    }
}

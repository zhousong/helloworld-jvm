package com.helloworld.direct;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by helloworld on 16/9/3.
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     at java.util.Arrays.copyOf(Arrays.java:3210)
     at java.util.Arrays.copyOf(Arrays.java:3181)
     at java.util.ArrayList.grow(ArrayList.java:261)
     at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
     at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
     at java.util.ArrayList.add(ArrayList.java:458)
 */
public class DirectBufferOOM {
    private static final int _1MB =  1024 * 1024;

    public static void main(String[] args) {
//        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
//        unsafeField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) unsafeField.get(null);
//        List<Long> list = new ArrayList<Long>();
//        while (true) {
//            final long l = unsafe.allocateMemory(_1MB);
//            System.out.println(l);
//            list.add(l);
//        }
        for (int i = 0; i < 1000000; i++) {
            ByteBuffer.allocateDirect(128);
        }
        System.out.println("Done");
    }
}

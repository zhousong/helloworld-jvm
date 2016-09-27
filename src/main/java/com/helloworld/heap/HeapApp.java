package com.helloworld.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class HeapApp {
    public static void main(String[] args) {
        System.out.println("Hello JVM-heap");
        List<ObjectClass> list = new ArrayList<ObjectClass>();

        while (true) {
            list.add(new ObjectClass());
        }
    }

    static class ObjectClass {
    }
}

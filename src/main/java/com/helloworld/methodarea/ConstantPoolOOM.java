package com.helloworld.methodarea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by helloworld on 16/9/3.
 *
 * Java8:-XX:MetaspaceSize=10M
 * before: -XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class ConstantPoolOOM {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<String>();

        while (true) {
            System.out.println(i);
            list.add(String.valueOf(i++).intern());
        }
    }
}

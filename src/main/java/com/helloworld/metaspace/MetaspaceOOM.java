package com.helloworld.metaspace;

import javassist.ClassPool;

/**
 * 1、如果设置Metaspace较小，堆较大，Metaspace 会先OOM
 * -server -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=50m -Xms1g -Xmx1g -XX:SurvivorRatio=2
 * <p>
 * 2、如果设置Metaspace较大，堆较小，则java.lang.OutOfMemoryError: GC overhead limit exceeded
 * -server -XX:MetaspaceSize=500m -XX:MaxMetaspaceSize=500m -Xms1g -Xmx1g -XX:SurvivorRatio=2
 * <p>
 * 另外注意：即使MetaspaceSize设置了比较250m，jvm启动时，初始化的Metaspace容量也不是250m
 */
public class MetaspaceOOM {

    public static void main(String[] args) {
        ClassPool classPool = ClassPool.getDefault();
        try {
            for (int i = 0; i < Long.MAX_VALUE; i++) {
//                TimeUnit.MILLISECONDS.sleep(1);
                Class<?> clazz = classPool.makeClass("com.helloworld.NewClass_" + i).toClass();
                System.out.println(i);
                if (i == 100) {
                    System.out.println(clazz);
                }
                if (i == 10000) {
                    System.out.println(clazz);
                }
                if (i == 50000) {
                    System.out.println(clazz);
                }
                if (i == 80000) {
                    System.out.println(clazz);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

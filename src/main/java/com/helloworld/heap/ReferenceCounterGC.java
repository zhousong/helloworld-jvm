package com.helloworld.heap;

import java.util.concurrent.TimeUnit;

/**
 * Created by helloworld on 16/9/3.
 * G1 : -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC
 */
public class ReferenceCounterGC {
    public ReferenceCounterGC instance;

    public static void main(String[] args) throws InterruptedException {
        ReferenceCounterGC o1 = new ReferenceCounterGC();
        ReferenceCounterGC o2 = new ReferenceCounterGC();

        o1.instance = o2;
        o2.instance = o1;

        System.gc();

        TimeUnit.MINUTES.sleep(1);

    }
}
//G1垃圾回收 和 默认垃圾回收日志对比:
//[Full GC (System.gc())  1230K->369K(20M), 0.0034113 secs]
//   [Eden: 2048.0K(10.0M)->0.0B(10.0M) Survivors: 0.0B->0.0B Heap: 1231.0K(20.0M)->369.8K(20.0M)], [Metaspace: 2843K->2843K(1056768K)]
// [Times: user=0.01 sys=0.00, real=0.01 secs]
//Heap
// garbage-first heap   total 20480K, used 369K [0x00000007bec00000, 0x00000007bed000a0, 0x00000007c0000000)
//  region size 1024K, 1 young (1024K), 0 survivors (0K)
// Metaspace       used 3026K, capacity 4494K, committed 4864K, reserved 1056768K
//  class space    used 337K, capacity 386K, committed 512K, reserved 1048576K
//---------------------------------
//[GC (System.gc()) [PSYoungGen: 1171K->432K(9216K)] 1171K->440K(19456K), 0.0008876 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
//[Full GC (System.gc()) [PSYoungGen: 432K->0K(9216K)] [ParOldGen: 8K->369K(10240K)] 440K->369K(19456K), [Metaspace: 2844K->2844K(1056768K)], 0.0058773 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
//Heap
// PSYoungGen      total 9216K, used 573K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
//  eden space 8192K, 7% used [0x00000007bf600000,0x00000007bf68f730,0x00000007bfe00000)
//  from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
//  to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
// ParOldGen       total 10240K, used 369K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
//  object space 10240K, 3% used [0x00000007bec00000,0x00000007bec5c400,0x00000007bf600000)
// Metaspace       used 3026K, capacity 4494K, committed 4864K, reserved 1056768K
//  class space    used 337K, capacity 386K, committed 512K, reserved 1048576K


package com.helloworld.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * -Xmn80m -Xms500m -Xmx500m  -XX:+UseConcMarkSweepGC  -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -XX:+PrintGCDetails  -XX:+PrintGCTimeStamps  -Xloggc:/Users/helloworld/logs/gc.log -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n -Dcom.sun.management.jmxremote.port=9999 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
 */
public class FullGc {
    public static void main(String[] args) throws Exception {
        System.out.println("start");

        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 10000; i++) {
            Person person = new Person();
            person.setId("id");
            person.setName("name");
            person.setAddr("addr");
            list.add(person);
        }
        TimeUnit.SECONDS.sleep(100);
        System.gc();

        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);
        list.remove(list.size() - 1);

        System.gc();
        TimeUnit.SECONDS.sleep(1000);

        System.out.println("end");
    }

    static class Person {
        private String id;
        private String name;
        private String addr;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }
    }
}
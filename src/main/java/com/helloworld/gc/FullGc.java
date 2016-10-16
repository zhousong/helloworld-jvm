package com.helloworld.gc;

import java.util.ArrayList;
import java.util.List;

public class FullGc {
    public static void main(String[] args) {
        System.out.println("start");

        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 10000; i++) {
            Person person = new Person();
            person.setId("id");
            person.setName("name");
            person.setAddr("addr");
            list.add(person);
        }
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
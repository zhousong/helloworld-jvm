package com.helloworld.methodarea;

/**
 * Created by helloworld on 16/9/3.
 *
 * 注意: s.intern() 是一个Native方法
 */
public class StringInternDemo {
    public static void main(String[] args) {
        // 首次出现,需要放入常量池
        String s = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s.hashCode());
        System.out.println(s.intern().hashCode());
        System.out.println(s.intern() == s);

        System.out.println("------------------");
        // 字符串常量池已经存在java,
        String ss = new StringBuilder("ja").append("va").toString();
        System.out.println(ss.hashCode());
        String sss = "java";
        // ss == sss 指向常量池的同一个字符串
        System.out.println(sss.hashCode());

        System.out.println(ss.intern() == ss);

    }
}

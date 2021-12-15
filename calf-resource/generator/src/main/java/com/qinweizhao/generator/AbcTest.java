package com.qinweizhao.generator;

/**
 * @author qinweizhao
 * @since 2021/12/15
 */
public class AbcTest {
    public static void main(String[] args) {
        String s ="/code/generator/src/main/java";
        String property = System.getProperty("user.dir");
        String userHome = System.getProperty("user.home");
        System.out.println(property+s);
        System.out.println(userHome);
    }
}

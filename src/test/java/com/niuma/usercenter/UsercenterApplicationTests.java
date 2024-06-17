package com.niuma.usercenter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsercenterApplicationTests {

    @Test
    @BeforeAll
    public static void contextLoads() {
        System.out.println("执行全部");
    }

    @Test
    @BeforeEach
    void niuma() {
        System.out.println("我是牛马");
    }

    @Test
    void common() {
        System.out.println("我是普通的方法");
    }
}

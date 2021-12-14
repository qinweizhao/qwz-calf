package com.qinweizhao.system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class CalfSystemApplicationTests {

    @Resource
    PasswordEncoder passwordEncoder;

    @Test
    void getPass() {
        String password = "123456";
        System.out.println(passwordEncoder.encode(password));
    }


}

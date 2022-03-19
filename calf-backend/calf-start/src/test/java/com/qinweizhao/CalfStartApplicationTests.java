package com.qinweizhao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;

@SpringBootTest
class CalfStartApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }


    @Test
    void testDir(){
        String userDir = System.getProperty("user.dir");
        File file = new File(userDir);
        File parentFile = file.getParentFile();
        File parentFile1 = parentFile.getParentFile();
        String parent = file.getParent();
        System.out.println(userDir);
        System.out.println("parentFile = " + parent);
        System.out.println("parentFile = " + parentFile);
        System.out.println("parentFile = " + parentFile1);
    }

}


package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.Impl.Impl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

    }
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Impl impl;

}

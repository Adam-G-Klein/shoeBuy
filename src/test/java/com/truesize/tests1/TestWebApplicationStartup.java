package com.truesize.tests1;

import com.truesize.HomeController;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestWebApplicationStartup {


    @Autowired
    private HomeController controller;

    @Test
    public void contextLoads() {
        //test that the spring context is able to load, if this test fails there
        // is a dependency issue
    }

    @Test
    public void controllerRegisteredWithSpring() {
        assertThat(controller).isNotNull();
    }

}

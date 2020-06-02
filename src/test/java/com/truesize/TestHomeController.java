package com.truesize;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHomeController {

    @Mock
    private Logger logger;

    @Mock
    private AccountService ac;

    @InjectMocks
    private HomeController controller;

    @Test
    public void homeRedirect() {
        when(ac.isLoggedIn()).thenReturn(false);
        assert(controller.index("/").contains("redirect"));
    }

    @Test
    public void homeIndex() {
        when(ac.isLoggedIn()).thenReturn(true);
        assert(controller.index("/").contains("index"));
    }
}

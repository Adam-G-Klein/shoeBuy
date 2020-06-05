package com.truesize.tests5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.truesize.AccountService;
import com.truesize.OwnedShoe;
import com.truesize.UserController;
import com.truesize.UserProfile;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGetUserInfo {

    @Mock
    private Logger logger;
    @Mock
    public AccountService ac;

    @InjectMocks
    private UserController controller;

    String testEmail = "test@email.com";
    String testPassword = "123456";

    @Test
    public void getUserInfo() {
    	UserProfile profile = new UserProfile(testEmail, testPassword);
        profile.ownedShoes.add(new OwnedShoe("testshoe1","adidas", 12.0, "f", "URL"));
        profile.ownedShoes.add(new OwnedShoe("testshoe2","nike", 13.0, "m", "URL"));
        when(ac.getProfile()).thenReturn(profile);

        UserProfile up = controller.getUserInfo();

        //assert that the information returned in the user profile is correct
        assert(up.getEmail() == testEmail);
        assert(up.getPassword() == testPassword);
    }

    @Test
    public void getUserShoes() {
    	UserProfile profile = new UserProfile(testEmail, testPassword);
        profile.ownedShoes.add(new OwnedShoe("testshoe1","adidas", 12.0, "f", "URL"));
        profile.ownedShoes.add(new OwnedShoe("testshoe2","nike", 13.0, "m", "URL"));
        when(ac.getProfile()).thenReturn(profile);

        List<OwnedShoe> oss = controller.getUserShoes();
        //assert that the returned list contains the expected number of owned shoes 
        assert(oss.size() == 2);
    }
}

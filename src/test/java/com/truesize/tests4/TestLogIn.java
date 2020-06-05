package com.truesize.tests4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.truesize.AccountService;
import com.truesize.AllUserRepository;
import com.truesize.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLogIn {

	@Mock
	private Logger logger;

    @Autowired
    private AllUserRepository aur;

    @InjectMocks
    private AccountService ac;

    String testPassword = "123456";

    @Test
    public void emailNotFound(){
    	aur.deleteAll();
        //assert that the user account is not in the repo
        UserProfile up = aur.findByEmail("test@email.com");
        assert(up == null);

        //assert that createAccount returns false
        assert(!ac.logIn("test@email.com", testPassword, aur));
    }

    @Test
    public void incorrectPassword(){
        String testEmail = "2test@email.com";
    	aur.deleteAll();
        //assert that the user account is in the repo
        aur.save(new UserProfile(testEmail, "correctpassword"));
        UserProfile up = aur.findByEmail(testEmail);
        assert(up != null);

        //assert that createAccount returns false
        assert(!ac.logIn(testEmail, "incorrectpassword", aur));
    }

    @Test
    public void logInSuccess(){
        String testEmail = "3test@email.com";
    	aur.deleteAll();
        //assert that the user account is in the repo
        aur.save(new UserProfile(testEmail, testPassword));
        UserProfile up = aur.findByEmail(testEmail);
        assert(up != null);

        //assert that createAccount returns true
        assert(ac.logIn(testEmail, testPassword, aur));

        //assert that loggedIn is now true
        assert(ac.isLoggedIn());
    }

}

package com.truesize;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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

    @Test
    public void emailNotFound(){
    	aur.deleteAll();
        //assert that the user account is not in the repo
        UserProfile up = aur.findByEmail("test@email.com");
        assert(up == null);

        //assert that createAccount returns false
        assert(ac.logIn("test@email.com", "123456", aur) == false);
    }

    @Test
    public void incorrectPassword(){
    	aur.deleteAll();
        //assert that the user account is in the repo
        aur.save(new UserProfile("2test@email.com", "correctpassword"));
        UserProfile up = aur.findByEmail("2test@email.com");
        assert(up != null);

        //assert that createAccount returns false
        assert(ac.logIn("2test@email.com", "incorrectpassword", aur) == false);
    }

    @Test
    public void logInSuccess(){
    	aur.deleteAll();
        //assert that the user account is in the repo
        aur.save(new UserProfile("3test@email.com", "123456"));
        UserProfile up = aur.findByEmail("3test@email.com");
        assert(up != null);

        //assert that createAccount returns true
        assert(ac.logIn("3test@email.com", "123456", aur) == true);

        //assert that loggedIn is now true
        assert(ac.isLoggedIn() == true);
    }

}

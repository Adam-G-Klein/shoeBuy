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
public class TestCreateAccount {

    @Autowired
    private AllUserRepository aur;

	@Mock
	private Logger logger;

    @InjectMocks
    private AccountService ac;

    @Test
    public void emailTaken(){
        String email = "4test@email.com";
    	aur.deleteAll();
        //assert that the user account is in the repo
        aur.save(new UserProfile(email, "123456"));
        UserProfile up = aur.findByEmail(email);
        assert(up != null);

        //assert that createAccount returns false
        assert(!ac.createAccount(email, "password", aur));
    }

    @Test
    public void emailAvailable(){
    	aur.deleteAll();
        //assert that the user account is not in the repo
        UserProfile up = aur.findByEmail("5test@email.com");
        assert(up == null);

        //assert that createAccount returns true
        assert(ac.createAccount("5test@email.com", "123456", aur));
    }
        
}

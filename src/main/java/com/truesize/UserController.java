package com.truesize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class UserController {

	private final AllUserRepository allUserRepository;

    @Autowired
    public AccountService ac;

    //@Autowired
	public UserController(AllUserRepository allUserRepository){
        this.allUserRepository = allUserRepository;
    }

    @GetMapping("/api/newUser")
    //void newUser(@RequestParam String email, @RequestParam String password){
    void newUser(@RequestParam String email, @RequestParam String password){
    	
        this.allUserRepository.save(new UserProfile(email, password));

    }

    @GetMapping("/api/logIn")
    void logIn(@RequestParam String email, @RequestParam String password){
        ac.logIn(email, password, allUserRepository);
    }

    @GetMapping("/api/logOut")
    void logOut(){
        ac.logOut();
    }


    //something to add a new shoe to a specific user

    // something to return all the shoes for a particular user

    // something to return profile information in JSON format



}
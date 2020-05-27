package com.truesize;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {


	public boolean loggedIn;
	public UserProfile profile;

	public AccountService(){
		this.loggedIn = false;
		this.profile = null;
	}

	public boolean logIn(String email, String password, AllUserRepository allUserRepository){

		profile = allUserRepository.findByEmail(email);

		if (profile != null){
			if (profile.getPassword().equals(password)){
				loggedIn = true;
				System.out.println("loggedIn should be set to true");
				return true;
			}
			System.out.println("Login Error: incorrect password");
		}

		else{
			System.out.println("Login Error: email not found");
		}
        return false;

	}

	public void logOut(){
		this.loggedIn = false;
		this.profile = null;
	}	
}
package com.truesize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

@Component
public class AccountService {

	private boolean loggedIn;
	private UserProfile profile;

	@Autowired
	private Logger logger;

	public AccountService(){
		loggedIn = false;
		profile = null;
	}

	public boolean logIn(String email, String password, AllUserRepository allUserRepository){

		profile = allUserRepository.findByEmail(email);

		if (profile != null){
			if (profile.getPassword().equals(password)){
				loggedIn = true;
				logger.info("loggedIn should be set to true");
				return true;
			}
			logger.info("Login Error: incorrect password");
		}

		else{
			logger.info("Login Error: email not found");
		}
        return false;

	}

	public void logOut(){
		this.loggedIn = false;
		this.profile = null;
	}	

	public boolean createAccount(String email, String password, AllUserRepository allUserRepository){
		profile = allUserRepository.findByEmail(email);

		if (profile != null){
			logger.info("CreateAccount Error: email already in database");
			return false;
		}

		allUserRepository.save(new UserProfile(email, password));
		logger.info("new user added to database");
		return true;

	}


	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
}

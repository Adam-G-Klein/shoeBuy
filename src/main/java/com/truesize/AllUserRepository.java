package com.truesize;

import org.springframework.data.repository.CrudRepository;
//import java.util.Optional;

public interface AllUserRepository extends CrudRepository<UserProfile, Long> {
	UserProfile findByEmail(String email);
}
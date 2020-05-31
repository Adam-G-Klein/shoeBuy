package com.truesize;

import org.springframework.data.repository.CrudRepository;

public interface AllUserRepository extends CrudRepository<UserProfile, Long> {
	UserProfile findByEmail(String email);
}
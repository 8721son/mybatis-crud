package com.won.project.repository;

import java.util.List;

import com.won.project.model.User;


public interface UserRepository {
	List<User> findAll();
	User findById(int id);
	int join(User user);
	User findByUsernameAndPassword(String username,String password);
	void update(int id,String userProfile);
}

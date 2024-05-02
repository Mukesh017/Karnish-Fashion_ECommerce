package com.karnish.service;

import java.util.List;

import com.karnish.exception.UserException;
import com.karnish.modal.User;

public interface UserService {

	public User findUserById(Long userId) throws UserException;

	public User findUserProfileByJwt(String jwt) throws UserException;

	public List<User> findAllUsers();

}

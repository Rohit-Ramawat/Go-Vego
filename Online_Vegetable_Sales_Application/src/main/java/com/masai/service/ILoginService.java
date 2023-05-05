package com.masai.service;

import com.masai.entity.User;

public interface ILoginService {
	
	public User validateLogin(User user);
	public User Logout(User user);
}

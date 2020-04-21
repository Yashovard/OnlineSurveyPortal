package com.sst.dao;


import com.sst.model.User;

public interface UserDao 
{
	public User verifyUser(String email_id, String password);
}

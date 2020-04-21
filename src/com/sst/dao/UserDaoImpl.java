package com.sst.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.sst.model.User;

public class UserDaoImpl implements UserDao
{
	DbConnection dbConnection;
	public User verifyUser(String email_id, String password)
	{
		User user=null;
		try {
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from registration_table where email_id='"+email_id+"' and password='"+password+"'");
			if(resultSet.next())
			{ 
				user=new User();
				user.setEmail_id(resultSet.getString(1));
				user.setPassword(resultSet.getString(2));
				user.setRole(resultSet.getString(3));
			}
			else
			{
				System.out.println("Email Id/Password does not match");
			}
		}
		catch(SQLException e)
		{
			System.out.println("excp==="+e);
		}
		return user;
	}
}

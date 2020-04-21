package com.sst.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection
{
	public Connection getconnection()
	{
		Connection connection=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinesurveyportal_db","root","root");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("excp="+e);
		}
		catch(SQLException e)
		{
			System.out.println("excp="+e);
		}
		return connection;
	}

}

package com.sst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sst.model.Member;
import com.sst.model.Survey;

public class MemberDaoImpl implements MemberDao
{
	DbConnection dbConnection;
	Member member;
	//***********************************************************************************************************************************************//
	public int insertMember(Member member)
	{
		int r=0;
		try 
		{
			dbConnection= new DbConnection();
			Connection connection= dbConnection.getconnection();
			int status=1;
			PreparedStatement preparedStatement=connection.prepareStatement("insert into mregistration(name,email_id,contact_no,city,state,country,status) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1,member.getName());
			preparedStatement.setString(2,member.getEmail_id());
			preparedStatement.setString(3,member.getContact_no());
			preparedStatement.setString(4,member.getCity());
			preparedStatement.setString(5,member.getState());
			preparedStatement.setString(6,member.getCountry());
			preparedStatement.setInt(7, status);
			r=preparedStatement.executeUpdate();
			insertintoregistration_table(member.getEmail_id(),member.getPassword());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return r;
	}
	//************************************************************************************************************//	
	public int insertintoregistration_table(String email_id,String password)
	{
		int r=0;
		try 
		{
			dbConnection= new DbConnection();
			Connection connection= dbConnection.getconnection();
			String roll="member";
			PreparedStatement preparedStatement=connection.prepareStatement("insert into registration_table(email_id,password,role) values(?,?,?)");
			preparedStatement.setString(1,email_id);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3, roll);
			r=preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return r;
	}
	//************************************************************************************************************//	

	public Member getFrommregistration(String email_id)
	{
		Member member= new Member();

		try
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT * FROM mregistration WHERE email_id='"+email_id+"'");
			while(resultSet.next())
			{
				member.setName(resultSet.getString(1));
				member.setEmail_id(resultSet.getString(2));
				member.setContact_no(resultSet.getString(3));
				member.setCity(resultSet.getString(4));
				member.setState(resultSet.getString(5));
				member.setCountry(resultSet.getString(6));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error...."+e);
		}
		return member;
	}
	//************************************************************************************************************//
	public int UpdateProfile(Member member)
	{
		int i=0;
		try
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();

			PreparedStatement preparedStatement=connection.prepareStatement("update mregistration set name=?,contact_no=?,city=?,state=?,country=? where email_id=?");
			preparedStatement.setString(6,member.getEmail_id());
			preparedStatement.setString(1,member.getName());
			preparedStatement.setString(2,member.getContact_no());
			preparedStatement.setString(3,member.getCity());
			preparedStatement.setString(4,member.getState());
			preparedStatement.setString(5,member.getCountry());
			i=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("excp==="+e);
		}
		return i;
	}
	//************************************************************************************************************//
	public List getEnableMember() 
	{
		Member member=null;
		List list=new ArrayList();
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from mregistration where status=1");
			while(resultSet.next())
			{
				member=new Member();
				member.setName(resultSet.getString(1));
				member.setEmail_id(resultSet.getString(2));
				member.setContact_no(resultSet.getString(3));
				member.setCity(resultSet.getString(4));
				member.setState(resultSet.getString(5));
				member.setCountry(resultSet.getString(6));
				list.add(member);
			}
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		return list;
	}
	//************************************************************************************************************//
	public int disableStatus(String EmailId)
	{
		int i=0;
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			int status=0;
			System.out.println("em="+EmailId);
			PreparedStatement preparedStatement=connection.prepareStatement("update mregistration set status=? where email_id=?");
			preparedStatement.setString(2,EmailId);
			preparedStatement.setInt(1, status);
			i=preparedStatement.executeUpdate();
		}
		catch (SQLException exception) 
		{
			System.out.println("excp=="+exception);
		}
		return i;
	}
	//************************************************************************************************************//
	public List getDisableMember()
	{

		Member member=null;
		List list=new ArrayList();
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from mregistration where status=0");
			while(resultSet.next())
			{
				member=new Member();
				member.setName(resultSet.getString(1));
				member.setEmail_id(resultSet.getString(2));
				member.setContact_no(resultSet.getString(3));
				member.setCity(resultSet.getString(4));
				member.setState(resultSet.getString(5));
				member.setCountry(resultSet.getString(6));
				list.add(member);
			}
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		return list;
	}
	//************************************************************************************************************//
	public int enableStatus(String EmailId)
	{
		int i=0;
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			int status=1;
			System.out.println("em="+EmailId);
			PreparedStatement preparedStatement=connection.prepareStatement("update mregistration set status=? where email_id=?");
			preparedStatement.setString(2,EmailId);
			preparedStatement.setInt(1, status);
			i=preparedStatement.executeUpdate();
		}
		catch (SQLException exception) 
		{
			System.out.println("excp=="+exception);
		}
		return i;
	}
}

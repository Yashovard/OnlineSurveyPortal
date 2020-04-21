package com.sst.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sst.model.Client;
import com.sst.model.Member;
/**
 *
 * @author Yashovardhan Singh 
 */
public class ClientDaoImpl implements ClientDao {
	DbConnection dbConnection;
	//***********************************************************************************************************************************************//
	public int insertClient(Client client)
	{
		int r=0;
		try
		{
			dbConnection=new DbConnection();
			Connection connection= dbConnection.getconnection();
			int status=1;
			PreparedStatement preparedStatement=connection.prepareStatement("insert into cregistration(company_name,email_id,address,city,state,postal,country,comp_contact,company_type,comp_person_name,designation,employee_id,cp_email,contact_no,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, client.getCompany_name());
			preparedStatement.setString(2, client.getEmail_id());
			preparedStatement.setString(3, client.getAddress());
			preparedStatement.setString(4, client.getCity());
			preparedStatement.setString(5, client.getState());
			preparedStatement.setString(6, client.getPostal_code());
			preparedStatement.setString(7, client.getCountry());
			preparedStatement.setString(8, client.getComp_contact());
			preparedStatement.setString(9, client.getCompany_type());
			preparedStatement.setString(10, client.getComp_person_name());
			preparedStatement.setString(11, client.getDesignation());
			preparedStatement.setString(12, client.getEmployee_id());
			preparedStatement.setString(13, client.getCp_email());
			preparedStatement.setString(14, client.getContact_no());
			preparedStatement.setInt(15, status);
			r=preparedStatement.executeUpdate();
			insertintoregistration_table(client.getEmail_id(),client.getPassword());
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		return r;
	}
	//************************************************************************************************************//
	public int insertintoregistration_table(String email_id, String password) {
		int r=0;
		try
		{
			dbConnection= new DbConnection();
			Connection con= dbConnection.getconnection();
			String roll="client";
			PreparedStatement ps=con.prepareStatement("insert into registration_table(email_id,password,role) values(?,?,?)");
			ps.setString(1,email_id);
			ps.setString(2,password);
			ps.setString(3, roll);
			r=ps.executeUpdate();
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		return r;
	}
	//************************************************************************************************************//
	public Client getFromcregistration(String email_id)
	{
		Client client= new Client();

		try
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT * FROM cregistration WHERE email_id='"+email_id+"'");
			while(resultSet.next())
			{
				client.setCompany_name(resultSet.getString(1));
				client.setEmail_id(resultSet.getString(2));
				client.setAddress(resultSet.getString(3));
				client.setCity(resultSet.getString(4));
				client.setState(resultSet.getString(5));
				client.setPostal_code(resultSet.getString(6));
				client.setCountry(resultSet.getString(7));
				client.setComp_contact(resultSet.getString(8));
				client.setCompany_type(resultSet.getString(9));
				client.setComp_person_name(resultSet.getString(10));
				client.setDesignation(resultSet.getString(11));
				client.setEmployee_id(resultSet.getString(12));
				client.setCp_email(resultSet.getString(13));
				client.setContact_no(resultSet.getString(14));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error...."+e);
		}
		return client;
	}
	//************************************************************************************************************//
	public int updateClinet(Client client) {
		int i=0
				;
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			PreparedStatement preparedStatement=connection.prepareStatement("update cregistration set address=?,city=?,state=?,postal=?,country=?,comp_contact=?,comp_person_name=?,designation=?,employee_id=?,cp_email=?,contact_no=? where email_id=?");
			preparedStatement.setString(12, client.getEmail_id());
			preparedStatement.setString(1, client.getAddress());
			preparedStatement.setString(2, client.getCity());
			preparedStatement.setString(3, client.getState());
			preparedStatement.setString(4, client.getPostal_code());
			preparedStatement.setString(5, client.getCountry());
			preparedStatement.setString(6, client.getComp_contact());
			preparedStatement.setString(7, client.getComp_person_name());
			preparedStatement.setString(8, client.getDesignation());
			preparedStatement.setString(9, client.getEmployee_id());
			preparedStatement.setString(10, client.getCp_email());
			preparedStatement.setString(11, client.getContact_no());
			i=preparedStatement.executeUpdate();
		}
		catch(SQLException exception) 
		{
			System.out.println(exception.getMessage());
		}
		return i;
	}
	//************************************************************************************************************//
	public List GetEnableClient() {
		Client client=null;
		List list=new ArrayList();
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from cregistration where status=1");
			while(resultSet.next())
			{
				client=new Client();
				client.setCompany_name(resultSet.getString(1));
				client.setEmail_id(resultSet.getString(2));
				client.setAddress(resultSet.getString(3));
				client.setCity(resultSet.getString(4));
				client.setState(resultSet.getString(5));
				client.setPostal_code(resultSet.getString(6));
				client.setCountry(resultSet.getString(7));
				client.setComp_contact(resultSet.getString(8));
				client.setCompany_type(resultSet.getString(9));
				client.setComp_person_name(resultSet.getString(10));
				client.setDesignation(resultSet.getString(11));
				client.setEmployee_id(resultSet.getString(12));
				client.setCp_email(resultSet.getString(13));
				client.setContact_no(resultSet.getString(14));
				list.add(client);
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
			PreparedStatement preparedStatement=connection.prepareStatement("update cregistration set status=? where email_id=?");
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
	//******************************************************************************************************************************//
	public List getDisableClient() {
		Client client=null;
		List list=new ArrayList();
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from cregistration where status=0");
			while(resultSet.next())
			{
				client=new Client();
				client.setCompany_name(resultSet.getString(1));
				client.setEmail_id(resultSet.getString(2));
				client.setAddress(resultSet.getString(3));
				client.setCity(resultSet.getString(4));
				client.setState(resultSet.getString(5));
				client.setPostal_code(resultSet.getString(6));
				client.setCountry(resultSet.getString(7));
				client.setComp_contact(resultSet.getString(8));
				client.setCompany_type(resultSet.getString(9));
				client.setComp_person_name(resultSet.getString(10));
				client.setDesignation(resultSet.getString(11));
				client.setEmployee_id(resultSet.getString(12));
				client.setCp_email(resultSet.getString(13));
				client.setContact_no(resultSet.getString(14));
				list.add(client);
			}
		}
		catch (Exception exception)
		{
			System.out.println(exception.getMessage());
		}
		return list;
	}
	//************************************************************************************************************************//
	public int enableStatus(String EmailId)
	{
		int i=0;
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			int status=1;
			System.out.println("em="+EmailId);
			PreparedStatement preparedStatement=connection.prepareStatement("update cregistration set status=? where email_id=?");
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

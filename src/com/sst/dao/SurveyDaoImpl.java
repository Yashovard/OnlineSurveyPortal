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

public class SurveyDaoImpl 
{
	DbConnection dbConnection;
	Survey survey;
	//***********************************************************************************************************************************************//
	public int insertSurvey(Survey survey)
	{
		int r=0;
		try 
		{
			dbConnection= new DbConnection();
			Connection connection= dbConnection.getconnection();
			int status=1;
			PreparedStatement preparedStatement=connection.prepareStatement("insert into survey_table(survey_title,survey_type,company_name,posted_by,start_date,end_date,status) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1,survey.getSurvey_title());
			preparedStatement.setString(2,survey.getSurvey_type());
			preparedStatement.setString(3,survey.getCompany_name());
			preparedStatement.setString(4,survey.getPosted_by());
			preparedStatement.setString(5,survey.getStart_date());
			preparedStatement.setString(6,survey.getEnd_date());
			preparedStatement.setInt(7, status);
			r=preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return r;
	}
	//************************************************************************************************************************************************//
	public List<Survey> getsurveyform()
	{
		Survey survey= null;
		List list= new ArrayList();
		try
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();

			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select* from survey_table");
			while(resultSet.next())
			{
				survey=new Survey();
				survey.setSurvey_no(resultSet.getInt(1));
				survey.setSurvey_title(resultSet.getString(2));
				survey.setSurvey_type(resultSet.getString(3));
				survey.setCompany_name(resultSet.getString(4));
				survey.setPosted_by(resultSet.getString(5));
				survey.setStart_date(resultSet.getString(6));
				survey.setEnd_date(resultSet.getString(7));
				list.add(survey);
			}
		}
		catch(SQLException e)	
		{
			System.out.println("Exception="+e);
		}
		return list;
	}
	//************************************************************************************************************************************************//
	public Survey getFromSurvey_table(String email_id)
	{
		Survey survey= new Survey();
		try
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT * FROM survey_table WHERE posted_by='"+email_id+"'");
			while(resultSet.next())
			{
				survey.setSurvey_no(resultSet.getInt(1));
				survey.setSurvey_title(resultSet.getString(2));
				survey.setSurvey_type(resultSet.getString(3));
				survey.setCompany_name(resultSet.getString(4));
				survey.setPosted_by(resultSet.getString(5));
				survey.setStart_date(resultSet.getString(6));
				survey.setEnd_date(resultSet.getString(7));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Error...."+e);
		}
		return survey;
	}
	//************************************************************************************************************************************************//
	public List getEnableSurvey()
	{
		Survey survey=null;
		List list=new ArrayList();
		try
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from survey_table where status=1");
			while(resultSet.next())
			{
				survey=new Survey();
				survey.setSurvey_no(resultSet.getInt(1));
				survey.setSurvey_title(resultSet.getString(2));
				survey.setSurvey_type(resultSet.getString(3));
				survey.setCompany_name(resultSet.getString(4));
				survey.setPosted_by(resultSet.getString(5));
				survey.setStart_date(resultSet.getString(6));
				survey.setEnd_date(resultSet.getString(7));
				list.add(survey);
			} 
		}
		catch (Exception exception) 
		{
			System.out.println(exception.getMessage());
		}

		return list;
	}
	//************************************************************************************************************************************************//
	public int disableStatus(int survey_no)
	{
		int i=0;
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			int status=0;
			PreparedStatement preparedStatement=connection.prepareStatement("update survey_table set status=? where survey_no=?");
			preparedStatement.setInt(2,survey_no);
			preparedStatement.setInt(1, status);
			i=preparedStatement.executeUpdate();
		}
		catch (SQLException exception) 
		{
			System.out.println("excp=="+exception);
		}
		return i;
	}
	//************************************************************************************************************************************************//
	public List getDisableSurvey()
	{
		Survey survey=null;
		List list=new ArrayList();
		try
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from survey_table where status=0");
			while(resultSet.next())
			{
				survey=new Survey();
				survey.setSurvey_no(resultSet.getInt(1));
				survey.setSurvey_title(resultSet.getString(2));
				survey.setSurvey_type(resultSet.getString(3));
				survey.setCompany_name(resultSet.getString(4));
				survey.setPosted_by(resultSet.getString(5));
				survey.setStart_date(resultSet.getString(6));
				survey.setEnd_date(resultSet.getString(7));
				list.add(survey);
			} 
		}
		catch (Exception exception) 
		{
			System.out.println(exception.getMessage());
		}

		return list;
	}
	//*****************************************************************************************************************************************************//
	public int enableStatus(int survey_no)
	{
		int i=0;
		try 
		{
			dbConnection=new DbConnection();
			Connection connection=dbConnection.getconnection();
			int status=1;
			PreparedStatement preparedStatement=connection.prepareStatement("update survey_table set status=? where survey_no=?");
			preparedStatement.setInt(2,survey_no);
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

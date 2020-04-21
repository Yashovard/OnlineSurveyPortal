package com.sst.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sst.model.Question;

public class QuestionDaoImpl implements QuestionDao {
	DbConnection dbConnection;
	Question question;

	// ***********************************************************************************************************************************************//
	public int insertquestion(Question question) {
		int r = 0;
		try {
			int status = 1;
			dbConnection = new DbConnection();
			Connection connection = dbConnection.getconnection();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into question_table(survey_no,questions,oa,ob,oc,od,status) values(?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, question.getSurvey_no());
			preparedStatement.setString(2, question.getQuestions());
			preparedStatement.setString(3, question.getOa());
			preparedStatement.setString(4, question.getOb());
			preparedStatement.setString(5, question.getOc());
			preparedStatement.setString(6, question.getOd());
			preparedStatement.setInt(7, status);
			r = preparedStatement.executeUpdate();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		return r;
	}

	// ***********************************************************************************************************************************************//
	public Question getFromquestion_table(int survey_no) {
		Question question = new Question();
		try {
			dbConnection = new DbConnection();
			Connection connection = dbConnection.getconnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM question_table WHERE survey_no=" + survey_no);
			while (resultSet.next()) {
				question.setQ_id(resultSet.getInt(1));
				question.setQuestions(resultSet.getString(2));
				question.setOa(resultSet.getString(3));
				question.setOb(resultSet.getString(4));
				question.setOc(resultSet.getString(5));
				question.setOd(resultSet.getString(6));
			}
		} catch (SQLException e) {
			System.out.println("Error...." + e);
		}
		return question;
	}

	// ***********************************************************************************************************************************************//
	public List getDisableMember() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getlist(int survey_no, int p) {
		Question question = null;
		List list = new ArrayList();
		try {
			dbConnection = new DbConnection();
			Connection connection = dbConnection.getconnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(
					"SELECT * FROM question_table WHERE survey_no=" + survey_no + " LIMIT " + p + "," + "1");
			while (resultSet.next()) {
				question = new Question();
				question.setQ_id(resultSet.getInt(2));
				question.setQuestions(resultSet.getString(3));
				question.setOa(resultSet.getString(4));
				question.setOb(resultSet.getString(5));
				question.setOc(resultSet.getString(6));
				question.setOd(resultSet.getString(7));
				list.add(question);
			}
		} catch (SQLException e) {
			System.out.println("Exception=" + e);
		}
		return list;
	}

	// ***********************************************************************************************************************************************//
	public Question getFromQuestion_table(int survey_no) {
		Question question = new Question();

		try {
			dbConnection = new DbConnection();
			Connection connection = dbConnection.getconnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM question_table WHERE survey_no=" + survey_no);
			while (resultSet.next()) {
				question.setSurvey_no(resultSet.getInt(1));
				question.setQ_id(resultSet.getInt(2));
				question.setQuestions(resultSet.getString(3));
				question.setOa(resultSet.getString(4));
				question.setOb(resultSet.getString(5));
				question.setOc(resultSet.getString(6));
				question.setOd(resultSet.getString(7));
			}
		} catch (SQLException e) {
			System.out.println("Error...." + e);
		}
		return question;
	}

	// ***********************************************************************************************************************************************//
	public int getcount(int survey_no) {
		Question question = null;
		int i = 0;
		try {
			dbConnection = new DbConnection();
			Connection connection = dbConnection.getconnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT COUNT(*) FROM question_table WHERE survey_no=?");

			preparedStatement.setInt(1, survey_no);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				i = rs.getInt(1);
			}

		} catch (SQLException e) {
			System.out.println("Exception=" + e);
		}
		return i;
	}
}

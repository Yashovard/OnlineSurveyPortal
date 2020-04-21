package com.sst.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sst.dao.QuestionDaoImpl;
import com.sst.dao.SurveyDaoImpl;
import com.sst.model.Question;
import com.sst.model.Survey;

public class Questionpage extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		HttpSession httpSession= request.getSession();
		String email_id = (String) httpSession.getAttribute("key");


		SurveyDaoImpl surveyDaoImpl= new SurveyDaoImpl();
		Survey survey= surveyDaoImpl.getFromSurvey_table(email_id);

		QuestionDaoImpl questionDaoImpl= new QuestionDaoImpl();
		Question question=questionDaoImpl.getFromquestion_table(survey.getSurvey_no());
	}
}

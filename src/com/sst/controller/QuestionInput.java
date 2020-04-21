package com.sst.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sst.dao.ClientDaoImpl;
import com.sst.dao.QuestionDaoImpl;
import com.sst.dao.SurveyDaoImpl;
import com.sst.model.Client;
import com.sst.model.Question;
import com.sst.model.Survey;
@WebServlet("/QuestionInp")
public class QuestionInput extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		if (request.getParameter("Add")!= null) 
		{
			HttpSession httpSession= request.getSession();
			String email_id = (String) httpSession.getAttribute("key");

			Question question= new Question();
			SurveyDaoImpl surveyDaoImpl= new SurveyDaoImpl();
			Survey survey= surveyDaoImpl.getFromSurvey_table(email_id);
			
			question.setSurvey_no(survey.getSurvey_no());
			question.setQuestions(request.getParameter("questions"));
			question.setOa(request.getParameter("oa"));
			question.setOb(request.getParameter("ob"));
			question.setOc(request.getParameter("oc"));
			question.setOd(request.getParameter("od"));

			QuestionDaoImpl questionDaoImpl= new QuestionDaoImpl();
			int i= questionDaoImpl.insertquestion(question);

			if (i > 0) 
			{
				out.println("Submission Successfull");
				request.getRequestDispatcher("QuestionInput.jsp").include(request, response);  
			} 
			else 
			{
				System.out.println("Error Occurs");
			}
		} 
		else if (request.getParameter("Finish")!= null) 
		{
			HttpSession httpSession= request.getSession();
			String email_id = (String) httpSession.getAttribute("key");

			Question question= new Question();
			SurveyDaoImpl surveyDaoImpl= new SurveyDaoImpl();
			Survey survey= surveyDaoImpl.getFromSurvey_table(email_id);
			question.setSurvey_no(survey.getSurvey_no());
			question.setQuestions(request.getParameter("questions"));
			question.setOa(request.getParameter("oa"));
			question.setOb(request.getParameter("ob"));
			question.setOc(request.getParameter("oc"));
			question.setOd(request.getParameter("od"));

			QuestionDaoImpl questionDaoImpl= new QuestionDaoImpl();
			int i= questionDaoImpl.insertquestion(question);

			if (i > 0) 
			{
				out.println("Submission Successfull");
				request.getRequestDispatcher("ClientHomepage.jsp").include(request, response); 
			} 
			else 
			{
				System.out.println("Error Occurs");
			}
		}
	}
}

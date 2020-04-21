package com.sst.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sst.dao.ClientDaoImpl;
import com.sst.dao.SurveyDaoImpl;
import com.sst.model.Client;
import com.sst.model.Survey;

@WebServlet("/Survey")
public class SurveyForm extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		HttpSession httpSession= request.getSession();
		String posted_by = (String) httpSession.getAttribute("key");

		Survey survey= new Survey();
		ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
		Client client= clientDaoImpl.getFromcregistration(posted_by);

		survey.setSurvey_title(request.getParameter("survey_title"));
		survey.setSurvey_type(request.getParameter("survey-type"));
		survey.setCompany_name(client.getCompany_name());
		survey.setPosted_by(client.getEmail_id());
		survey.setStart_date(request.getParameter("start_date"));
		survey.setEnd_date(request.getParameter("end_date"));

		SurveyDaoImpl surveyDaoImpl= new SurveyDaoImpl();
		int i= surveyDaoImpl.insertSurvey(survey);

		if (i > 0) 
		{
			request.getRequestDispatcher("SurveyHomepage.jsp").include(request, response);  
		} 
		else 
		{
			System.out.println("Error Occurs");
		}
	}
}

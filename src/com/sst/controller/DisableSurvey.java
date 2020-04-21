package com.sst.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sst.dao.SurveyDaoImpl;
import com.sst.model.Member;
import com.sst.model.Survey;
@WebServlet("/DisableSurvey")
public class DisableSurvey  extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		Survey survey=new Survey();
		int surveyno=Integer.parseInt(request.getParameter("surveyno"));
		SurveyDaoImpl surveyDaoImpl=new SurveyDaoImpl();
		int i=surveyDaoImpl.disableStatus(surveyno);
		if(i>0)
		{
			out.println("Disable Successfully");
			request.getRequestDispatcher("ManageClient.jsp").include(request, response);
		}
		else
		{
			out.println("Error..");
		}
	}
}

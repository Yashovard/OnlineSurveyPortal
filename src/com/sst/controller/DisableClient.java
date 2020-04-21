package com.sst.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sst.dao.ClientDaoImpl;
import com.sst.model.Client;
@WebServlet("/DisableClient")
public class DisableClient extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Client client=new Client();
		String email=request.getParameter("email");
		ClientDaoImpl clientDaoImpl=new ClientDaoImpl();
		int i=clientDaoImpl.disableStatus(email);
		if(i>0)
		{
			out.println("Disable Successfully");
			request.getRequestDispatcher("DisableClient.jsp").include(request, response); 
		}
		else
		{
			out.println("Error..");
		}
	}
}

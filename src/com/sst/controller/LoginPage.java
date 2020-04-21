package com.sst.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sst.dao.UserDaoImpl;

import com.sst.model.User;


@WebServlet("/Login")
public class LoginPage extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email_id=request.getParameter("email_id");
		String password=request.getParameter("password");
		HttpSession httpSession= request.getSession();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		User user;
		try
		{
			user=userDaoImpl.verifyUser(email_id, password);
			if(user.getRole().equals("member"))
			{
				httpSession.setAttribute("key",user.getEmail_id());
				response.sendRedirect("MemberHomepage.jsp");
			}
			else if(user.getRole().equals("client"))
			{
				httpSession.setAttribute("key",user.getEmail_id());
				response.sendRedirect("ClientHomepage.jsp");
			}
			else if(user.getRole().equals("admin"))
			{
				httpSession.setAttribute("key",user.getEmail_id());
				response.sendRedirect("AdminHomepage.jsp");
			}
		}
		catch(NullPointerException e)
		{
			response.sendRedirect("Homepage.jsp");
		}
		out.close();
	}
}

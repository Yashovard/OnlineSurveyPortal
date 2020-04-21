package com.sst.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sst.dao.*;
import com.sst.model.Member;
@WebServlet("/MReg")
public class MemberReg extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Member member=new Member();
		member.setName(request.getParameter("name"));
		member.setEmail_id(request.getParameter("email_id"));
		member.setPassword(request.getParameter("password"));
		member.setContact_no(request.getParameter("contact_no"));
		member.setCity(request.getParameter("city"));
		member.setState(request.getParameter("state"));
		member.setCountry(request.getParameter("country"));
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		int i = memberDaoImpl.insertMember(member);

		if (i > 0) 
		{
			out.println("Registration Successfull Please Login Now");
			request.getRequestDispatcher("LoginForm.jsp").include(request, response);  

		} 
		else 
		{
			System.out.println("Error Occurs");
		}
	}

}

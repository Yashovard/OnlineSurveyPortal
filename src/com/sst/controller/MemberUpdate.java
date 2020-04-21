package com.sst.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sst.dao.MemberDaoImpl;
import com.sst.model.Member;
@WebServlet("/MUpdate")
public class MemberUpdate extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Member member= new Member();
		member.setName(request.getParameter("name"));
		member.setEmail_id(request.getParameter("email_id"));
		member.setContact_no(request.getParameter("contact_no"));
		member.setCity(request.getParameter("city"));
		member.setState(request.getParameter("state"));
		member.setCountry(request.getParameter("country"));
		

		MemberDaoImpl memberDaoImpl=new MemberDaoImpl();
		int i=memberDaoImpl.UpdateProfile(member);

		if(i>0)
		{
			out.println("Updated Successfully");
			request.getRequestDispatcher("MemberHomepage.jsp").include(request, response);
		}
		else
		{
			out.println("Error..");
		}
	}

}

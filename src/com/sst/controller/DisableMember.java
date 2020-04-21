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
@WebServlet("/DisableMember")
public class DisableMember extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();	
		Member member=new Member();
		String email=request.getParameter("email");
		MemberDaoImpl memberDaoImpl=new MemberDaoImpl();
		int i=memberDaoImpl.disableStatus(email);
		if(i>0)
		{
			out.println("Disable Successfully");
			//request.getRequestDispatcher("ManageMember.jsp").include(request, response);
			response.sendRedirect("DisableMember.jsp");
		}
		else
		{
			out.println("Error..");
		}
	}
}


package com.sst.controller;
/**
 *
 * @author Yashovardhan Singh 
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sst.dao.ClientDaoImpl;
import com.sst.model.Client;
@WebServlet("/CReg")
public class ClientReg extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Client client=new Client();
		client.setCompany_name(request.getParameter("company_name"));
		client.setEmail_id(request.getParameter("email_id"));
		client.setAddress(request.getParameter("address"));
		client.setCity(request.getParameter("city"));
		client.setState(request.getParameter("state"));
		client.setPostal_code(request.getParameter("postal"));
		client.setCountry(request.getParameter("country"));
		client.setComp_contact(request.getParameter("comp_contact"));
		client.setPassword(request.getParameter("password"));
		client.setCompany_type(request.getParameter("company_type"));
		client.setComp_person_name(request.getParameter("comp_person_name"));
		client.setDesignation(request.getParameter("designation"));
		client.setEmployee_id(request.getParameter("employee_id"));
		client.setCp_email(request.getParameter("cp_email"));
		client.setContact_no(request.getParameter("contact_no"));
		ClientDaoImpl clientDaoImpl=new ClientDaoImpl();
		int i=clientDaoImpl.insertClient(client);
		if (i > 0) 
		{
			out.println("Registration Successfull Please Login Now");
			request.getRequestDispatcher("LoginForm.jsp").include(request, response);  
		} 
		else 
		{
			System.out.println("Error Occurs");
			request.getRequestDispatcher("CRegistration.jsp").include(request, response);  
		}	
	}
}

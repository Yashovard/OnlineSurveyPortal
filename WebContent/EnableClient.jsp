<%@page import="com.sst.model.Client"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sst.dao.ClientDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client List</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h2 align="center">View Client List</h2>
	<table border="3" align="center">
		<tr>
			<td>Company Name</td>
			<td>Email ID</td>
			<td>Address</td>
			<td>City</td>
			<td>State</td>
			<td>Postal</td>
			<td>Country</td>
			<td>Company Contact</td>
			<td>Company Type</td>
			<td>Company Person Name</td>
			<td>Designation</td>
			<td>Employee Id</td>
			<td>Company Person Email Id</td>
			<td>Contact Number</td>
			<td>Enable</td>
			</tr>
			<%
			List list=new ArrayList();
			ClientDaoImpl clientDaoImpl=new ClientDaoImpl();
			list=clientDaoImpl.GetEnableClient();
			Iterator iterator=list.iterator();
			while(iterator.hasNext())
			{
				Client client=(Client)iterator.next();
			%>
			<tr>
			<td><%=client.getCompany_name()%></td>
			<td><%=client.getEmail_id()%></td>
			<td><%=client.getAddress()%></td>
			<td><%=client.getCity()%></td>
			<td><%=client.getState()%></td>
			<td><%=client.getPostal_code()%></td>
			<td><%=client.getCountry()%></td>
			<td><%=client.getComp_contact()%></td>
			<td><%=client.getCompany_type()%></td>
			<td><%=client.getComp_person_name()%></td>
			<td><%=client.getDesignation()%></td>
			<td><%=client.getEmployee_id()%></td>
			<td><%=client.getCp_email()%></td>
			<td><%=client.getContact_no()%></td>
			<td><a href="DisableClient?email=<%=client.getEmail_id()%>">Click here to Enable</a></td>
		</tr>
		<%
			}
		%>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
<%@page import="com.sst.model.Client"%>
<%@page import="com.sst.dao.ClientDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Client Home Page</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<%
		try
	{
			String email_id = (String) session.getAttribute("key");
			ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
			Client client;

			if (!email_id.equals(null)) {
				client = clientDaoImpl.getFromcregistration(email_id);
				out.println("Welcome -" + client.getCompany_name() + "<br>");%>
	            <a href="ClientViewProfile.jsp?email_id=<%=client.getEmail_id()%>">View Profile</a><br>
	            <a href="SurveyForm.jsp">Create Survey Form</a><br>
	             <a href="ShowSurveyCreated.jsp">Post Survey Question</a><br>
	            <a href="Homepage.jsp">Back to Homepage</a><br>

	<%
			}
		} catch (NullPointerException e) {
			response.sendRedirect("LoginForm.jsp");
		}
	%>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
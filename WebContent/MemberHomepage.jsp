<%@page import="com.sst.model.Member"%>
<%@page import="com.sst.dao.MemberDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Member Homepage</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<%
		try {
			
			String email_id = (String) session.getAttribute("key");
			MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
			Member member;

			if (!email_id.equals(null)) {
				member = memberDaoImpl.getFrommregistration(email_id);
				out.println("Welcome -" + member.getName() + "<br>");%>
	            <a href="MemberViewProfile.jsp?email_id=<%=member.getEmail_id()%>">View Profile</a><br>
	            <a href="ShowSurveytoMember.jsp">View Surveys</a><br>
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
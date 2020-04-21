<%@page import="java.util.Iterator"%>
<%@page import="com.sst.model.Member"%>
<%@page import="com.sst.dao.MemberDaoImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member List</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<h2 align="center">View Member List</h2>
	<table border="3" align="center">
		<tr>
			<td>Name</td>
			<td>Email ID</td>
			<td>Contact No</td>
			<td>City</td>
			<td>State</td>
			<td>Country</td>
			</tr>
			<%
			List list=null;
			MemberDaoImpl memberDaoImpl=new MemberDaoImpl();
			list=memberDaoImpl.getDisableMember();
			Iterator iterator=list.iterator();
			while (iterator.hasNext()) {
			Member member=(Member)iterator.next();
			%>
			<tr>
			<td><%=member.getName()%></td>
			<td><%=member.getEmail_id()%></td>
			<td><%=member.getContact_no()%></td>
			<td><%=member.getCity()%></td>
			<td><%=member.getState()%></td>
			<td><%=member.getCountry()%></td>
			<td><a href="DisableMember?email=<%=member.getEmail_id()%>">Click here to enable</a></td>
		</tr>
		<%
			}
		%>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
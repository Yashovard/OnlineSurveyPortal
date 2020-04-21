<%@page import="com.sst.model.Member"%>
<%@page import="com.sst.dao.MemberDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Member Profile View</title>
</head>
<body>
	<%
		String email_id = request.getParameter("email_id");
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		Member member;
		try {
			member = memberDaoImpl.getFrommregistration(email_id);
	%>
	<jsp:include page="Header.jsp"></jsp:include>
	<h1 align="center">Profile</h1>
	<form action="MemberProfileUpdate.jsp">
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=member.getName()%>"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input type="text" name="email_id"
					value="<%=member.getEmail_id()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Contact No:</td>
				<td><input type="text" name="contact_no"
					value="<%=member.getContact_no()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" value="<%=member.getCity()%>"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state"
					value="<%=member.getState()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country"
					value="<%=member.getCountry()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Update Profile" /></td>
			</tr>
		</table>
		<%
			} catch (NullPointerException e) {
				out.println("user does not exists");

			}
		%>

		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>
<%@page import="com.sst.model.Member"%>
<%@page import="com.sst.dao.MemberDaoImpl"%><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Member Profile Update</title>
</head>
<body>
	<script>
		function validateform() {

			var name = document.Name.name.value;
			var contact_no = document.Name.contact_no.value;
			var city = document.Name.city.value;
			var state = document.Name.state.value;
			var country = document.Name.country.value;

			if (name == null || name == "") {
				alert("Name can't be blank");
				return false;
			} else if (!name.match(/^[a-zA-Z]+$/)) {
				alert("Only alphabets are allowed in Name");
				return false;
			} else if (contact_no == "" || isNaN(contact_no)
					|| contact_no.length != 10) {
				alert("Contact Number Field Can't be Blank/Please Provide Proper Contact Number");
				return false;
			} else if (city == null || city == "") {
				alert("City Field could not be blank");
				return false;
			} else if (!city.match(/^[a-zA-Z]+$/)) {
				alert("Only alphabets are allowed in City");
				return false;
			} else if (state == null || state == "") {
				alert("State Field could not be blank");
				return false;
			} else if (!state.match(/^[a-zA-Z]+$/)) {
				alert("Only alphabets are allowed in State");
				return false;
			} else if (country == null || country == "") {
				alert("Country Field could not be blank");
				return false;
			} else if (!country.match(/^[a-zA-Z]+$/)) {
				alert("Only alphabets are allowed in Country");
				return false;
			}
		}
	</script>
	<%
		String email_id = request.getParameter("email_id");
		MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
		Member member;
		try {
			member = memberDaoImpl.getFrommregistration(email_id);
	%>
	<jsp:include page="Header.jsp"></jsp:include>
	<h1 align="center">Update Profile</h1>
	<form name="Name" action="MUpdate" onsubmit="return validateform()">
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="<%=member.getName()%>"></td>
			</tr>
			<tr>
				<td>Email_id:</td>
				<td><input type="text" name="email_id"
					value="<%=member.getEmail_id()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Contact_no:</td>
				<td><input type="text" name="contact_no"
					value="<%=member.getContact_no()%>"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" value="<%=member.getCity()%>"></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state"
					value="<%=member.getState()%>"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country"
					value="<%=member.getCountry()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save Data" /></td>
			</tr>
		</table>
		<%
			} catch (NullPointerException e) {
				out.println("user does not exists");

			}
		%>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
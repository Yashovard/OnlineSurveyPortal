<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Member Registration Form</title>
</head>
<body>
	<script>
		function validateform() {
			var filter = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
			var name = document.Name.name.value;
			var email_id = document.Name.email_id.value;
			var password = document.Name.password.value;
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
			} else if (email_id == null || email_id == "") {
				alert("Email Id Field could not be blank");
				return false;
			} else if (!filter.test(email_id)) {
				alert("Please provide a valid email address");
				return false;
			} else if (password == null || password == "") {
				alert("Password Field could not be blank");
				return false;
			} else if (!passw.test(password)) {
				alert("Password must be of 6 to 20 characters  which contain at least one numeric digit, one uppercase ,one lowercase letter");
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
	<jsp:include page="Header.jsp"></jsp:include>
	<br>
	<br>
	<h1 align="center">Member Registration Form</h1>
	<form name="Name" action="MReg" method="post"
		onsubmit="return validateform()">
		
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input type="text" name="email_id"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Contact No.:</td>
				<td><input type="text" name="contact_no"></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country"></td>
			</tr>
			<br>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Register" /></td>
			</tr>
		</table>
		<br> <br> <br> <br>
		<br>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
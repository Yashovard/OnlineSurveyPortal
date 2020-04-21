<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Login Here</title>
</head>
<body>
	<script>
		function validateform() {
			var filter = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
			var email_id = document.Name.email_id.value;
			var password = document.Name.password.value;

			if (email_id == null || email_id == "") {
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
			}
		}
	</script>
	<jsp:include page="Header.jsp"></jsp:include>
	<h1 align="center">Login Here</h1>
	<form name="Name" action="Login" onsubmit="return validateform()">
		<table align="center">
			<tr>
				<td>Email Id:</td>
				<td><input type="text" name="email_id"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>

	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>
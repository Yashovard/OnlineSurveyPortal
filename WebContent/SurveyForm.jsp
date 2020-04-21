<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Survey Form</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<br>
	<br>
	<h1 align="center">Survey Form</h1>
	<form action="Survey" method="post">

		<table align="center">
		<tr>
				<td>Survey Title/Name:</td>
				<td><input type="text" name="survey_title"></td>
			</tr>
			<tr>
				<td>Survey Type:</td>
				<td><select name="survey_type">
						<option value=""></option>
						<option value="product">Product</option>
						<option value="services">Services</option>
						<option value="Food">Food</option>
						<option value="ECommerce">E-Commerce></option>
						<option value="Website">Website</option>
						<option value="NGo">NGo</option>
						<option value="Others"><label for="Others">Others</label></option>
				</select></td>
			</tr>
			<tr>
				<td>Start Date:</td>
				<td><input type="date" name="start_date"></td>
			</tr>
			<tr>
				<td>End Date:</td>
				<td><input type="date" name="end_date"></td>
			</tr>
			<br>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Create  Survey" /></td>
			</tr>
		</table>
		<br> <br> <br> <br> <br>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
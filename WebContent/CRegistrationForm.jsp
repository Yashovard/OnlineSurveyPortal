<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Client Registration</title>
</head>
<body>
	<script>
		function validateform() {
			var filter = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
			var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
			var company_name = document.Name.company_name.value;
			var company_type = document.Name.company_type.value;
			var email_id = document.Name.email_id.value;
			var address = document.Name.address.value;
			var city = document.Name.city.value;
			var state = document.Name.state.value;
			var postal = document.Name.postal.value;
			var country = document.Name.country.value;
			var comp_contact = document.Name.comp_contact.value;
			var password = document.Name.password.value;

			var comp_person_name = document.Name.comp_person_name.value;
			var designation = document.Name.designation.value;
			var employee_id = document.Name.employee_id.value;
			var cp_email = document.Name.cp_email.value;
			var contact_no = document.Name.contact_no.value;

			if (company_name == null || company_name == "") {
				alert("Company Name can't be blank");
				return false;
			} else if (company_type == null || company_type == "") {
				alert("Company Type Field could not be blank");
				return false;
			} else if (email_id == null || email_id == "") {
				alert("Email Id Field could not be blank");
				return false;
			} else if (!filter.test(email_id)) {
				alert("Please provide a valid email address");
				return false;
			} else if (address == null || address == "") {
				alert("Street Address Field could not be blank");
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
			} else if (postal == null || postal == "") {
				alert("Postal Address could not be blank");
				return false;
			} else if (country == null || country == "") {
				alert("Country Field could not be blank");
				return false;
			} else if (!country.match(/^[a-zA-Z]+$/)) {
				alert("Only alphabets are allowed in Country");
				return false;
			} else if (comp_contact == "" || isNaN(comp_contact)
					|| comp_contact.length != 10) {
				alert("Contact Number Field Can't be Blank/Please Provide Proper Contact Number");
				return false;
			} else if (password == null || password == "") {
				alert("Password Field could not be blank");
				return false;
			} else if (!passw.test(password)) {
				alert("Password must be of 6 to 20 characters  which contain at least one numeric digit, one uppercase ,one lowercase letter");
				return false;
			}

			else if (comp_person_name == null || comp_person_name == "") {
				alert("Contact Person Name could not be blank");
				return false;
			}  else if (!comp_person_name.match(/^[a-zA-Z\s-, ]+$/)) {
				alert("Only alphabets are allowed in Name");
				return false;
			} else if (designation == null || designation == "") {
				alert("Company Name can't be blank");
				return false;
			} else if (!designation.match(/^[a-zA-Z\s-, ]+$/)) {
				alert("Only alphabets are allowed in Designation");
				return false;
			} else if (employee_id == null || employee_id == "") {
				alert("Employee Id can't be blank");
				return false;
			} else if (cp_email == null || cp_email == "") {
				alert(" Contact Pereson Email Id Field could not be blank");
				return false;
			} else if (!filter.test(cp_email)) {
				alert("Please provide a valid email address for Contat Person");
				return false;
			} else if (contact_no == "" || isNaN(contact_no)
					|| contact_no.length != 10) {
				alert("Contact Number Field Can't be Blank/Please Provide Proper Contact Number");
				return false;
			}
		}
	</script>
	<jsp:include page="Header.jsp"></jsp:include>
	<br>

	<h1 align="center">Client Registration Form</h1>
	<form name="Name" action="CReg" method="post"
		onsubmit="return validateform()">
		<table align="center">
			<tr>
				<td>Name of Company / Firm:</td>
				<td><input type="text" name="company_name"></td>
			</tr>
			<tr>
				<td>Type of Company:</td>
				<td><select name="company_type">
						<option value=""></option>
						<option value="It">IT</option>
						<option value="Healthcare">Health care</option>
						<option value="BasicIndustry">Basic Industry</option>
						<option value="Education">Education</option>
						<option value="Marketing">Marketing</option>
						<option value="Finance">Finance</option>
						<option value="Others">Others</option>
				</select></td>
			</tr>
			<tr>
				<td>Email Id of Company / Firm:</td>
				<td><input type="text" name="email_id"></td>
			</tr>
			<tr>
				<td>Street Address:</td>
				<td><input type="text" name="address"></td>
				<td>City:</td>
				<td><input type="text" name="city"></td>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state"></td>

				<td>Postal / Zip code:</td>
				<td><input type="text" name="postal"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country"></td>
				</td>
				<td>Contact No. of Company or Firm:</td>
				<td><input type="text" name="comp_contact"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td>- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
					- - - - - - - - - - - - - - - - - - - - - - - -</td>
			</tr>
			<tr>
				<td><h3 align="center">Contact Person Details</h3></td>
			</tr>
		</table>
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="comp_person_name"></td>
			</tr>
			<tr>
				<td>Position in Company / Firm:</td>
				<td><input type="text" name="designation"></td>
				<td>Employee Id:</td>
				<td><input type="text" name="employee_id"></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input type="text" name="cp_email"></td>

				<td>Contact number:</td>
				<td><input type="text" name="contact_no"></td>
			</tr>
			<table align="center">
				<tr>
					<td colspan="2"><input type="submit" value="submit"></td>
				</tr>
			</table>
		</table>
		</table>
		<br> <br>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
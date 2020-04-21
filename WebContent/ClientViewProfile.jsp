<%@page import="com.sst.model.Client"%>
<%@page import="com.sst.dao.ClientDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>

<title>Client View Profile</title>
</head>
<body>
<%
String email_id=request.getParameter("email_id");
ClientDaoImpl clientDaoImpl=new ClientDaoImpl();
Client client;
try
{
	client=clientDaoImpl.getFromcregistration(email_id);
%>

<jsp:include page="Header.jsp"></jsp:include>
<h1 align="center">Profile</h1>
<form action="ClientProfileUpdate.jsp">
<table align="center">
<tr>
				<td>Name of Company / Firm:</td>
				<td><input type="text" name="company_name" value="<%=client.getCompany_name() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Type of Company:</td>
				<td> <input type="text" name="comp_type" value="<%=client.getCompany_type() %>"readonly="readonly"></td>
			</tr>
			<tr>
				<td>Email Id of Company / Firm:</td>
				<td><input type="text" name="email_id" value="<%=client.getEmail_id() %>"readonly="readonly"></td>
			</tr>
			<tr>
				<td>Street Address:</td>
				<td><input type="text" name="address" value="<%=client.getAddress()%>" readonly="readonly"></td>
				<td>City:</td>
				<td><input type="text" name="city" value="<%=client.getCity()%>" readonly="readonly"></td></tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state" value="<%=client.getState()%>" readonly="readonly"></td>
				<td>Postal / Zip code:</td>
				<td><input type="text" name="postal" value="<%=client.getPostal_code()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type="text" name="country" value="<%=client.getCountry()%>" readonly="readonly"></td>
				</td>
				<td>Contact No. of Company or Firm:</td>
				<td><input type="text" name="comp_contact" value="<%=client.getComp_contact()%>" readonly="readonly"></td>
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
				<td><input type="text" name="comp_person_name" value="<%= client.getComp_person_name()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Position in Company / Firm:</td>
				<td><input type="text" name="designation" value="<%=client.getDesignation() %>" readonly="readonly"></td>
				<td>Employee Id:</td>
				<td><input type="text" name="employee_id" value="<%=client.getEmployee_id()%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Email Id:</td>
				<td><input type="text" name="cp_email" value="<%= client.getEmail_id()%>" readonly="readonly"></td>

				<td>Contact number:</td>
				<td><input type="text" name="contact_no" value="<%=client.getContact_no()%>" readonly="readonly"></td>
			</tr>
			<table align="center">
				<tr>
					<td colspan="2"><input type="submit" value="Update"></td>
				</tr>
			</table>
		</table>
		
		<br> <br>
		<%
			} 
		catch (Exception e)
		{
				out.println("user does not exists");

			}
		%>
		<jsp:include page="Footer.jsp"></jsp:include>
	</form>
</body>
</html>
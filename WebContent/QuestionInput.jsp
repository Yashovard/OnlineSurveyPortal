<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Input Question Here</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<br>
	<br>
	<table align="center" border="1" width="900px" bgcolor="0CEED4">
		<tr>
			<td width="100%">
				<form method="POST" action="QuestionInp">

					<h2 align="center">Question Submission Form</h2>
					<table>
						<tr>
							<td><b>Enter Question:</b></td>
							<td><input type="text" name="questions" size="100" /></td>
						</tr>
						<tr>
							<td><b>Option A:</b></td>
							<td><input type="text" name="oa" size="100" /></td>
						</tr>
						<tr>
							<td><b>Option B:</b></td>
							<td><input type="text" name="ob" size="100" /></td>
						</tr>

						<tr>
							<td><b>Option C:</b></td>
							<td><input type="text" name="oc" size="100" /></td>
						</tr>

						<tr>
							<td><b>Option D:</b></td>
							<td><input type="text" name="od" size="100" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit" name="Add" value="Add More Question" />
							 <input type="submit" name="Finish" value="Finish" /></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
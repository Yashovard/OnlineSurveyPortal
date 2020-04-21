<%@page import="com.sst.dao.QuestionDaoImpl"%>
<%@page import="com.sst.model.Survey"%>
<%@page import="com.sst.model.Question"%>
<html>
<head>
<title>JSP Page</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<table align="center" border="1" width="900px" bgcolor="0CEED4">
		<tr>
			<td width="100%">

				<h2 align="center">Question Submission Form</h2>
		<tr>
			<td width="100%">



				<h2 align="center">
					<font color="red">Online Quize Application</font>
				</h2> <b>Select Correct Answer</b>
				<table border="0" width="500px" cellspacing="2" cellpadding="4">
					<tr>

						<td width="50%">Question:</td>

						<td><%=%></td>
					</tr>
					<tr>
						<td>1: <input type="radio" name="a" value="QA" /></td>
						<td><%=%></td>
					</tr>
					<tr>
						<td>2: <input type="radio" name="a" value="QB" /></td>
						<td><%=%></td>
					</tr>

					<tr>
						<td>3: <input type="radio" name="a" value="QC" /></td>
						<td><%=%></td>
					</tr>

					<tr>
						<td>4: <input type="radio" name="a" value="QD" />
						</td>
						<td><%=%></td>
					</tr>

					<tr>
						<td>
							<center>
								<input type="submit" value="Submit" name="submit">
							</center>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

</body>
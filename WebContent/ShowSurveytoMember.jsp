<%@page import="com.sst.dao.MemberDaoImpl"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sst.dao.SurveyDaoImpl"%>
<%@page import="com.sst.model.Survey"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Surveys</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>

	<h2 align="center">Created Survey</h2>
	<table border="3" align="center">
		<tr>
			<td>Survey Number</td>
			<td>Company Name</td>
			<td>Survey Title/Name</td>
			<td>Survey Type</td>
			<td>Posted By</td>
			<td>Start Date</td>
			<td>End Date</td>
			<td>Fill Survey</td>
		</tr>
		<%
			List list = null;
			SurveyDaoImpl surveyDaoImpl = new SurveyDaoImpl();
			list = surveyDaoImpl.getsurveyform();
			Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				Survey survey = (Survey) iterator.next();
		%>
		<tr>
			<td><%=survey.getSurvey_no()%></td>
			<td><%=survey.getCompany_name()%>
			<td><%=survey.getSurvey_title()%></td>
			<td><%=survey.getSurvey_type()%></td>
			<td><%=survey.getPosted_by()%></td>
			<td><%=survey.getStart_date()%></td>
			<td><%=survey.getEnd_date()%></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
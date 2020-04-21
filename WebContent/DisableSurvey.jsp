<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.sst.model.Survey"%>
<%@page import="com.sst.dao.SurveyDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Survey List</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<h2 align="center">View Disable Survey</h2>
	<table border="3" align="center">
		<tr>
			<td>Survey No</td>
			<td>Tittle</td>
			<td>Survey Type</td>
			<td>Company Name</td>
			<td>Posted By</td>
			<td>Start Date</td>
			<td>End Date</td>
			<td>Enable</td>
		</tr>
		<%
			List list=null;
			SurveyDaoImpl surveyDaoImpl = new SurveyDaoImpl();
			list = surveyDaoImpl.getDisableSurvey();
			Iterator iterator=list.iterator();
			while (iterator.hasNext()) {
				Survey survey = (Survey) iterator.next();
		%>
		<tr>
			<td><%=survey.getSurvey_no()%></td>
			<td><%=survey.getSurvey_title()%></td>
			<td><%=survey.getSurvey_type()%></td>
			<td><%=survey.getCompany_name()%></td>
			<td><%=survey.getPosted_by()%></td>
			<td><%=survey.getStart_date()%></td>
			<td><%=survey.getEnd_date()%></td>
			<td><a href="EnableSurvey?surveyno=<%=survey.getSurvey_no()%>">Click here to enable</a></td>
		</tr>
		<%
			}
		%>
		<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
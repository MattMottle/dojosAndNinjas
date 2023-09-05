<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form action="/dojos/new/process" method="post" modelAttribute="dojo">
		<div style="color: red;"><form:errors path="name"/></div>	
		<p>
			<form:label path="name">Dojo Name:</form:label>
			<form:input path="name"/>
		</p>
		<button class="button">Create</button>
	</form:form>
</body>
</html>
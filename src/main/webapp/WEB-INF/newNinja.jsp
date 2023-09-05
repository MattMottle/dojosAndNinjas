<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/new/process" method="post" modelAttribute="ninja">
			<div style="color: red;"><form:errors path="firstName"/></div>
			<div style="color: red;"><form:errors path="lastName"/></div>
			<div style="color: red;"><form:errors path="age"/></div>
			<form:label path="dojo">Dojo:</form:label>		
			<form:select path="dojo">
		        <c:forEach var="oneDojo" items="${dojos}">
		            <form:option value="${oneDojo.id}" path="dojo">
		                <c:out value="${oneDojo.name}"/>
		            </form:option>
		        </c:forEach>
	    	</form:select>
			<p>
				<form:label path="firstName">First Name:</form:label>
				<form:input path="firstName"/>
			</p>
			<p>
				<form:label path="lastName">Last Name:</form:label>
				<form:input path="lastName"/>
			</p>
			<p>
				<form:label path="age">Age:</form:label>
				<form:input type="number" path="age"/>
			</p>
			<button class="button">Create</button>
		</form:form>
	</div>
</body>
</html>
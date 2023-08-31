<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos and Ninjas</title>
</head>
<body>
	<h1>Dojo's:</h1>
	<div>
		<c:forEach var="dojo" items="${dojos}">
			<p><a href="dojos/${dojo.id}"><c:out value="${dojo.name}"/></a>
		</c:forEach>
	</div>
	<hr>
	<div>
	<p><a href="/dojos/new">Create New Dojo</a></p>
	<p><a href="/ninjas/new">Create New Ninja</a></p>
	</div>
</body>
</html>
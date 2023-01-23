<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="/JaiProject/URLResources/css/my-style-sheet.css">

</head>
<body>

<div align="center">
<h3>Add Student</h3>

<!-- Create Form -->
<div class="card1">
<form:form action="save-student" modelAttribute="student" method="POST" >

<form:hidden path="id"/>

<label>Name: </label>
<form:input path="name"/>
<br>
<br>

<label>Mobile: </label>
<form:input path="mobile"/>
<br>
<br>
<label>Country: </label>
<form:input path="country"/>
<br>
<br>
<br>
<input type="submit" class="mybtn" value="Submit">

</form:form>
</div>
</div>
</body>
</html>
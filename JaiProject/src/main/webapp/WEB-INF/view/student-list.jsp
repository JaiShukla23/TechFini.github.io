<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tech-Fini</title>

<link rel="stylesheet" type="text/css" href="/JaiProject/URLResources/css/my-style-sheet.css">

</head>
<body>
<h1 align="center"><marquee><b>Welcome to TECH-FINI...</b></marquee></h1>
<h6>Click to given "ADD HERE" button for add New Person...</h6>
<form action="showAddStudentPage">
	<input type="submit"  class="Add" value="ADD HERE">
	</form>
<br>

<div class="card" align="center">
	
<table border="1">	
<thead>
	<tr>
	<td>id</td>
	<td>name</td>
	<td>mobile</td>
	<td>country</td>
	<td colspan="2">Update/Clear</td>
	</tr>
</thead>

	<c:forEach var="student" items="${students }">
	<tr>
	<td>${student.id}</td>
	<td>${student.name}</td>
	<td>${student.mobile}</td>
	<td>${student.country}</td>
	
	<td><a href="/JaiProject/updateStudent?userId=${student.id}">Update</a></td>
	<td><a href="/JaiProject/deleteStudent?userId=${student.id}" onclick="if(!(confirm('Are you sure you want to delete this data')))return false">Delete</a></td>
</tr>
</c:forEach>
</table>


</div>
<footer>
 <div class="footer">
              <div class="auto-container">
                <div class="inner-container">
                       <ul class="footer-nav">
                           <li><a href="#">Terms of Service</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                      </ul> 

                        <div class="text">
                            <p>Copyright © 2022 All Rights Reserved by <a href="#">TECH-FINI</a></p>
                        </div>
                     </div>
               </div>
            </div>
            </footer>
</body>
</html>
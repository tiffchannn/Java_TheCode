<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
 
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="UTF-8">
<title>Secret Code</title>
</head>
<body>
	<h3 class="error"><c:out value="${error}"/></h3>
	<h2>What is the code?</h2>
	<div>
		<form method="POST" action="/codeSubmission">
			<input type="text" name="input" class="form-control">
			<button class="btn">Try Code</button>
		</form>
	</div>


</body>
</html>
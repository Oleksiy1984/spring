
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>


<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Project Manager</title>
	<link href="alex/favicon.ico" rel="icon" type="image/x-icon">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="fragments/header.jsp"></jsp:include>

<div class="container">

	<h2>Current Project</h2>
	<ul class="list-group">
		<li class="list-group-item"><label>Project Name:</label><span>${currentProject.name }</span></li>
		<li class="list-group-item"><label>Sponsor:</label><span>${currentProject.sponsor.name }</span></li>
		<li class="list-group-item"><label>Description:</label><br/><span>${currentProject.description }</span></li>
	</ul>

</div>
<jsp:include page="fragments/footer.jsp"></jsp:include>
</body>
</html>


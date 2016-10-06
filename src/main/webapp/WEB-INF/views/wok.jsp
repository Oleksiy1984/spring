<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 05.10.2016
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WOL</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
    <link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>
<jsp:include page="fragments/header.jsp"></jsp:include>
<spring:url value="/wok" var="url"/>
<form:form action="${url}" method="POST" modelAttribute="waker" class="col-md-8 col-md-offset-2">


    <div class="form-group">
        <label for="IP">IP</label>
        <form:input path="IP" cssClass="form-control" id="IP"/>
    </div>

    <div class="form-group">
        <label for="MACADDR">MAC</label>
        <form:select path="MACADDR" id="MACADDR" items="${typeOptions}" cssClass="selectpicker"/>
    </div>

    <button type="submit" class="btn btn-default">Send</button>

</form:form>

</body>
</html>

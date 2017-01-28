<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Issue</title>
    <link href="<c:url value='/resources/bootstrap.min.css' />" rel="stylesheet"/>
</head>
<body>

<div class="container">

    <sf:form commandName="issueCommand" method="post">
        <label for="type">Issue Type:</label>
        <input type="text" name="type" id="type">
        <sf:errors path="name" cssClass="error"/>

        <label for="description">Issue Description:</label>
        <input type="text" name="description" id="description">
        <sf:errors path="description" cssClass="error"/>

        <input type="hidden" name="projectId" id="projectId" value="${projectId}">

        <input type="submit" value="submit" class="btn btn-success">

    </sf:form>
</div>
</body>
</html>
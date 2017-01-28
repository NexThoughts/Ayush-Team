<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Project</title>
    <link href="<c:url value='/resources/bootstrap.min.css' />" rel="stylesheet"></link>
</head>
<body>

<form:form commandName="project">
   ProjectName: <input type="text" name="name" id="username">
    <form:errors path="name" cssClass="error" />
    <input type="submit" value="submit">

</form:form>
</body>
</html>

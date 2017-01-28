<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Project</title>
    <link href="<c:url value='/resources/bootstrap.min.css' />" rel="stylesheet"></link>
</head>
<body>

<div class="container">

    <sf:form commandName="projectCO">
        <label for="name">Project Name:</label>
        <input type="text" name="name" id="name">
        <sf:errors path="name" cssClass="error"/>

        <label for="description">ProjectDescription:</label>
        <input type="text" name="description" id="description">
        <sf:errors path="description" cssClass="error"/>
        <input type="submit" value="submit" class="btn btn-success">

    </sf:form>
</div>
</body>
</html>

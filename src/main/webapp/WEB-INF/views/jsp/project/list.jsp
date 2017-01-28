<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%--
  Created by IntelliJ IDEA.
  User: abhinav
  Date: 28/1/17
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <table class="table-responsive">
        <c:if test="${projectList.isEmpty()}">
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3">
                    <div class="alert alert-danger">No Student Record's Found</div>
                </div>
            </div>
        </c:if>
        <c:if test="${!projectList.isEmpty()}">
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3">
                    <tr>
                        <th>ID-</th>
                        <th>Project Name</th>
                        <th>Project Description</th>
                        <th>Project Date Creation</th>
                        <th>Project Date Creation</th>
                        <th>EDIT</th>
                        <th>DELETE</th>
                    </tr>
                    <c:forEach items="${projectList}" var="project" varStatus="counter">

                        <tr>
                            <td>${counter.index+1}</td>
                            <td>${project.getName()}</td>
                            <td>${project.getDescription()}</td>
                            <td><a class="btn btn-success" href="<s:url value="edit?${project.getId()}"/>">Edit</a>
                            <%--<td><a class="btn btn-success" href="<s:url value="edit?identity=${project.getId()}"/>">Edit</a>--%>
                            </td>
                        </tr>
                    </c:forEach>
                </div>
            </div>
        </c:if>
    </table>
</div>
</body>
</html>

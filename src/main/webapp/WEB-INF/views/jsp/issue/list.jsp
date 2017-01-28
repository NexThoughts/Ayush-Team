<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Issue List</title>
</head>
<body>
<div class="container">
    <table class="table-responsive">
        <c:if test="${issueList.isEmpty()}">
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3">
                    <div class="alert alert-danger">No Issues Found</div>
                </div>
            </div>
        </c:if>
        <c:if test="${!issueList.isEmpty()}">
            <div class="row">
                <div class="col-lg-6 col-lg-offset-3">
                    <tr>
                        <th>ID-</th>
                        <th>Issue Type</th>
                        <th>Issue Description</th>
                        <th>Issue Date Creation</th>
                        <th>Issue Date Creation</th>
                        <th>EDIT</th>
                        <th>DELETE</th>
                    </tr>
                    <c:forEach items="${issueList}" var="issue" varStatus="counter">

                        <tr>
                            <td>${counter.index+1}</td>
                            <td>${issue.getType()}</td>
                            <td>${issue.getDescription()}</td>
                            <td><a class="btn btn-success" href="<s:url value="edit?id=${project.getId()}"/>">Edit</a>
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
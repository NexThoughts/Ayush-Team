<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Student</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/bootstrap.min.css" />">
    <style>
        span.error {
            background-color: #ffcccc;
            border: 2px solid red;
        }
    </style>
</head>
<body>
<div class="container-fluid">

    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <h3 class="text-center">Edit Project</h3>
            <sf:form method="post" cssClass="form-horizontal" commandName="projectCO">
                <div class="col-lg-6 col-lg-offset-3">
                    <fieldset>
                        <label class="text-left control-label" for="name">Project Name</label>
                        <sf:input cssClass="pull-right form-control input-md" path="name"
                                  placeholder="Enter project name"/>
                        <sf:errors path="name" cssClass="error"/><br>
                    </fieldset>

                    <fieldset>
                        <label class="text-left control-label" for="description">Project Description</label>
                        <sf:input cssClass="pull-right form-control input-md" path="description"
                                  placeholder="Enter Project Description"/>
                        <sf:errors path="description" cssClass="error"/><br>
                    </fieldset>

                    <fieldset>
                        <br>
                        <div class="row">
                            <div class="col-lg-6 col-lg-offset-3">
                                <div class="pull-left">
                                    <input type="submit" value="Update" class="btn btn-success ">
                                </div>
                                <div class="pull-right">
                                    &nbsp;<a class="btn btn-info" href="<s:url value="/project/list"/>">Back</a>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </sf:form>
        </div>
    </div>
</div>
</body>
</html>
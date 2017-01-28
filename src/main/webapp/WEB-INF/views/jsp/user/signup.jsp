<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
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
    <div class="page-header" style="background-color: #66afe9;margin: 0px !important;">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3 text-center text-capitalize" style=""><h1><b>User Registration</b></h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <h3 class="text-center"><s:message code="create.user"/></h3>
            <sf:form method="post" cssClass="form-horizontal" commandName="userCommand">
                <div class="col-lg-6 col-lg-offset-3">
                    <fieldset>
                        <label class="text-left control-label" for="firstName">First Name</label>
                        <input class="pull-right form-control input-md" name="firstName" id="firstName"
                               placeholder="Enter first Name"/>
                        <sf:errors path="firstName" cssClass="error"/><br>
                        <br>
                    </fieldset>

                    <fieldset>
                        <label class="text-left control-label" for="lastName">Last Name</label>
                        <input class="pull-right form-control input-md" name="lastName" id="lastName"
                               placeholder="Enter last Name"/>
                        <sf:errors path="lastName" cssClass="error" /><br>
                        <br>
                    </fieldset>

                    <fieldset>
                        <label class="text-left control-label" for="email">Email Address</label>
                        <input class="pull-right form-control input-md" name="email" id="email"
                               placeholder="Enter email address"/>
                        <sf:errors path="email" cssClass="error"/><br>
                        <br>
                    </fieldset>
                    <fieldset>
                        <label class="text-left control-label" for="username">Username</label>
                        <input class="pull-right form-control input-md" name="username" id="username"
                               placeholder="Enter username"/>
                        <sf:errors path="username" cssClass="error"/><br>
                        <br>
                    </fieldset>
                    <fieldset>
                        <label class="text-left control-label" for="password">Password</label>
                        <input type="password" class="pull-right form-control input-md" name="password" id="password"
                               placeholder="Enter password"/>
                        <sf:errors path="password" cssClass="error"/><br>
                        <br>
                    </fieldset>
                    <fieldset>
                        <label class="text-left control-label" for="password">Confirm Password</label>
                        <input type="password" class="pull-right form-control input-md" name="confirmPassword"
                               id="confirmPassword"
                               placeholder="Repeat your password"/>
                        <sf:errors path="confirmPassword" cssClass="error"/><br>
                        <br>
                    </fieldset>
                    <fieldset>
                        <br>
                        <div class="row">
                            <div class="col-lg-8 col-lg-offset-2">
                                <div class="pull-left">
                                    <input type="submit" value="Register" class="btn btn-success ">
                                </div>
                                <div class="pull-right">
                                    &nbsp;<a class="btn btn-info" href="<s:url value="/login"/>"><s:message
                                        code="signup.back"/></a>
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

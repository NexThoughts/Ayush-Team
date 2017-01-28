<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>
<head>
    <title>Login</title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/bootstrap.min.css" />">
</head>
<body>
<div class="container-fluid">
    <div class="page-header" style="background-color: #66afe9;margin: 0px !important;">
        <div class="row">
            <div class="col-lg-6 col-lg-offset-3 text-center text-capitalize" style=""><h1><b>Spring Security Demo</b>
            </h1></div>
        </div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <h2 class="text-center"><s:message code="user.login"/></h2>
            <form method="post" class="form-horizontal">
                <div class="col-lg-6 col-lg-offset-3">
                    <c:if test="${logout != null}">
                        <div class="alert alert-success">
                            <strong>Success!</strong> You have been successfully logged out.
                        </div>
                    </c:if>
                    <c:if test="${success != null}">
                        <div class="alert alert-success">
                            <strong><s:message
                                    code="signup.successful"/>
                        </div>
                    </c:if>
                    <c:if test="${error != null}">
                        <div class="alert alert-danger">
                            <strong>Oops!</strong> Could not find a user with these credentials.
                        </div>
                    </c:if>
                    <br>
                    <fieldset>
                        <label class="text-left control-label" for="username">Username</label>
                        <input class="pull-right form-control input-md" type="text" name="username" id="username"
                               placeholder="Username"/>
                        <br>
                    </fieldset>

                    <fieldset>
                        <label class="text-left control-label" for="password">Password</label>
                        <input class="pull-right form-control input-md" type="password" name="password" id="password"
                               placeholder="Password"/>
                        <br>
                    </fieldset>

                    <fieldset>
                        <br>
                        <div class="pull-left">
                            <input type="submit" value="Login" class="btn btn-success ">
                        </div>
                        <div class="pull-right">
                            &nbsp;<a class="btn btn-info" href="<s:url value="/signup"/>"><s:message
                                code="user.signup"/></a>
                        </div>
                    </fieldset>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>--%>



<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Login</title>

    <link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name"></h1>

        </div>
        <h3>Welcome to Fintech Track</h3>

        <p>Login in. To see it in action.</p>
        <h2 class="text-center"><s:message code="user.login"/></h2>
        <c:if test="${logout != null}" >
            <div class="alert alert-success">
                <strong>Success!</strong> You have been successfully logged out.
            </div>
        </c:if>
        <c:if test="${error != null}" >
            <div class="alert alert-danger">
                <strong>Oops!</strong> Could not find a user with these credentials.
            </div>
        </c:if>
        <form method="post" class="form-horizontal m-t"  role="form">
            <div class="form-group">
                <input type="text" class="form-control" name="username" id="username" required placeholder="Username">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" id="password"
                       placeholder="Password" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

            <a href="#"><small>Forgot password?</small></a>
            <p class="text-muted text-center"><small>Do not have an account?</small></p>
            <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>
        </form>
        <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2014</small> </p>
    </div>
</div>

<!-- Mainly scripts -->
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
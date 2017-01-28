<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

    <style>
        span.error {
            background-color: #ffcccc;
            border: 2px solid red;
        }
    </style>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <h3><s:message code="create.user"/></h3>
        <sf:form method="post" cssClass="form-horizontal signup" commandName="userCommand">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="First Name" required="" name="firstName" id="firstName" value="${userCommand.firstName}">
                <span class="form-errors-inline"><sf:errors path="firstName"/><br></span>

            </div>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Last Name" required="" name="lastName" value="${userCommand.lastName}">
                <span class="form-errors-inline"><sf:errors path="lastName"/><br></span>

            </div>
            <div class="form-group">
                <input type="text" class="form-control username" placeholder="User Name" required="" name="username" id="username"  value="${userCommand.username}">
                <span class="form-errors-inline"><sf:errors path="username"/><br></span>

            </div>
            <div class="form-group">
                <input type="email" class="form-control" placeholder="Email" required="" name="email" id="email"  value="${userCommand.email}">
                <span class="form-errors-inline"><sf:errors path="email"/><br></span>

            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" required="" name="password" id="password"  value="${userCommand.password}">
                <span class="form-errors-inline"><sf:errors path="password"/><br></span>

            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Confirm Password" required=""  value="${userCommand.confirmPassword}"
                       name="confirmPassword" id="confirmPassword">
                <span class="form-errors-inline"><sf:errors path="confirmPassword"/><br></span>

            </div>
            <%--<div class="form-group">
                <div class="checkbox i-checks"><label> <input type="checkbox"><i></i> Agree the terms and policy
                </label></div>
            </div>--%>
            <button type="submit" class="btn btn-primary block full-width m-b">Register</button>

            <p class="text-muted text-center">
                <small>Already have an account?</small>
            </p>
            <a class="btn btn-sm btn-white btn-block" href="/login">Login</a>
        </sf:form>

    </div>
</div>

<!-- Mainly scripts -->
<!-- Mainly scripts -->
<script src="<c:url value="/resources/js/jquery-2.1.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/plugins/validate/jquery.validate.min.js" />"></script>

<script>
    jQuery(document).ready(function () {

        $(".signup").validate({
            rules: {
                username: {
                    required: true,
                    remote: {
                        url: "/checkUnique",
                        type: "post",
                        data: {
                            username: function () {
                                return $('.username').val();
                            }

                        }
                    }
                },
                password: {

                    required: true,
                    minlength: 5
                },
                confirmPassword: {
                    required: true,
                    minlength: 5,
                    equalTo: "#password"

                }


            },
            messages: {
                password: "Please enter a password.",
                rpassword: {
                    required: 'Please retype password'
//                    equalTo: "Passwords must match."
                },
                username: {
                    required: "Please enter username",
                    remote: jQuery.validator.format(" Someone already has this username. Try another!")
                }

            }

        });
    });
</script>

</body>

</html>
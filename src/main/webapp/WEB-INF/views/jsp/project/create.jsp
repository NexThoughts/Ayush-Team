<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Project</title>

    <link href="<c:url value="/resources/bootstrap.min.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">


    <link href="<c:url value="/resources/css/plugins/dataTables/dataTables.responsive.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/plugins/dataTables/dataTables.tableTools.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/plugins/dataTables/dataTables.bootstrap.css" />" rel="stylesheet">


    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet"
          type="text/css"/>
    <style>
        .form-errors-inline {
            color: red;
        }

        table {
            font-size: small;
        }

        .table-responsive {
            min-height: .01%;
            overflow-x: hidden;
        }

        body {
            color: rgba(0, 0, 0, 0.67)
        }
    </style>
</head>

<body>
<div class="gray-bg" id="page-wrapper" style="margin:0px">
    <div class="row border-bottom">
        <nav class="navbar navbar-fixed-top" role="navigation"
             style="margin-bottom: 0;background:radial-gradient(at 0% 50%, #F7F7F7 15%, #EFEFF0 50%, #E0E1E2 100%);height:70px;">
            <div class="navbar-header">
                <div class="row">
                    <div class="col-sm-1 col-md-3">
                        <a class="navbar-minimalize minimalize-styl-2" href="#">
                            <img class="img-responsive" width="100%"
                                 src="<c:url value="/resources/img/a3.jpg" />"/>
                        </a>
                    </div>

                    <div class="col-md-5" style="margin-top: 12px">
                        <ul class="nav navbar-top-links navbar-right" style="margin-left: 50px;">
                            <li>
<span style="color:rgba(0, 0, 0, 0.67); font-size: 15px;">Welcome
<security:authentication property="principal.username"/> </span>
                            </li>
                            <li class="dropdown">
                                <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
    <span style="color:rgba(0, 0, 0, 0.67); font-size: 15px;font-weight: bold">
    <b class="caret"></b></span>
                                </a>
                                <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                    <li><a href="#">Edit Profile</a></li>
                                    <li><a href="#">Change Password</a></li>
                                    <li class="divider"></li>
                                    <li><a href="/logout">Logout</a></li>
                                </ul>
                            </li>
                        </ul>

                    </div>
                </div>

            </div>

        </nav>

    </div>

    <div class="grey-bg" style="margin-top: 5%">

        <div class="wrapper wrapper-content animated fadeInRight ecommerce">

            <div class="row">
                <div class="col-lg-12">
                    <div class="tabs-container">

                        <div class="tab-content">
                            <div id="tab-1" class="tab-pane active">
                                <div class="panel-body">
                                    <div class="col-lg-10">
                                        <h2>Create Project </h2>

                                    </div>

                                    <div class="row wrapper wrapper-content">
                                        <div class="col-md-12">
                                            <div class="ibox-content">
                                                <div class="col-md-7">
                                                    <sf:form commandName="projectCO" cssClass="form-horizontal" method="post">
                                                        <div class="form-group"><label class="col-sm-3 control-label">Project
                                                            Name:</label>
                                                            <div class="col-sm-9"><input name="name" id="name"
                                                                                          type="text"
                                                                                          class="form-control"></div>
                                                            <span class="form-errors-inline"> <sf:errors path="name"
                                                                                                         cssClass="error"/><br></span>
                                                        </div>
                                                        <div class="form-group"><label class="col-sm-3 control-label">Description
                                                        </label>
                                                            <div class="col-sm-9">
                                                                <textarea name="description" id="description" rows="10" cols="50"
                                                                          type="text"
                                                                          class="form-control"></textarea>
                                                            </div>
                                                            <span class="form-errors-inline"> <sf:errors
                                                                    path="description"
                                                                    cssClass="error"/><br></span>
                                                        </div>

                                                        <input type="submit" value="submit" class="btn btn-success">

                                                    </sf:form>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="footer">
    <div>
        &copy; <strong>Copyright</strong> 2016 You Track. All Rights Reserved.
    </div>
</div>

<!-- Mainly scripts -->
<script src="<c:url value="/resources/js/jquery-2.1.1.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/plugins/metisMenu/jquery.metisMenu.js"/>"></script>
<script src="<c:url value="/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"/>"></script>
<script src="<c:url value="/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"/>"></script>

<!-- Data Tables -->
<script src="<c:url value="/resources/js/plugins/dataTables/jquery.dataTables.js"/>"></script>
<script src="<c:url value="/resources/js/plugins/dataTables/dataTables.bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/plugins/dataTables/dataTables.responsive.js"/>"></script>
<script src="<c:url value="/resources/js/plugins/dataTables/dataTables.tableTools.min.js"/>"></script>


<!-- Custom and plugin javascript -->
<script src="<c:url value="/resources/js/inspinia.js"/>"></script>
<script src="<c:url value="/resources/js/plugins/pace/pace.min.js"/>"></script>

<!-- Toastr -->
<script src="<c:url value="/resources/js/plugins/summernote/summernote.min.js"/>"></script>

<script>
    $(document).ready(function () {
        $('.summernote').summernote();
    });
</script>
</body>
</html>

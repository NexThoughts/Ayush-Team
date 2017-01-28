<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>--%>

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
                                        <h2>Project List</h2>

                                    </div>

                                    <div class="row wrapper wrapper-content">
                                        <div class="col-md-12">
                                            <div class="ibox-content">
                                                <a href="/project/create"
                                                   class="btn btn-primary btn-sm">Create New
                                                    Project</a><br><br>
                                                <c:if test="${projectList.isEmpty()}">
                                                    <div class="row">
                                                        <div class="col-lg-6 col-lg-offset-3">
                                                            <div class="alert alert-danger">No Student Record's
                                                                Found
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:if>
                                                <c:if test="${!projectList.isEmpty()}">
                                                <table class="table table-striped table-bordered table-hover dataTables-example">
                                                    <thead>
                                                    <tr>
                                                        <th>ID-</th>
                                                        <th>Name</th>
                                                        <th>Project Date Creation</th>
                                                        <th>Action</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach items="${projectList}" var="project"
                                                               varStatus="counter">

                                                        <tr>
                                                            <td>${counter.index+1}</td>
                                                            <td>${project.getName()}</td>
                                                            <td>${project.getDateCreated()}</td>
                                                            <td><a class="btn btn-sm btn-success"
                                                                   href="issue/list?projectId=${project.getId()}">View</a>
                                                                &nbsp;
                                                                <a class="btn btn-sm btn-warning"
                                                                   href="<s:url value="issue/list?projectId=${project.getId()}"/>">Edit</a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                                </c:if>

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

<script>
    $(document).ready(function () {
        $('.dataTables-example').dataTable({
            responsive: true
            // "dom": 'T<"clear">lfrtip'
            // "tableTools": {
            // "sSwfPath": "js/plugins/dataTables/swf/copy_csv_xls_pdf.swf"
            // }


        });
    });

</script>

</body>
</html>

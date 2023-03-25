<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
<%--        <script type="text/javascript" href="<%=request.getContextPath()%>/webjars/jquery/3.6.1/dist/jquery.min.js"></script>--%>
        <link rel="stylesheet" href="<%=request.getContextPath()%>/webjars/bootstrap/5.2.0/css/bootstrap.min.css">
        <script src="<%=request.getContextPath()%>/webjars/font-awesome/6.1.2/js/all.js"></script>
        <title>Welcome Admin</title>
    </head>
    <body class="bg-light">
    <div class="d-flex flex-column row">
        <div class="bg-success py-2">
            <span class="text-white mx-2">Administrator</span>
            <i class="fa-regular fa-user text-white float-end mx-4"></i>
            <i class="fa-regular fa-bell text-white float-end mx-1"></i>
        </div>
        <div class="bg-dark vh-100 col-2">
            <div class="m-2">
                <i class="fa-solid fa-house text-white"></i>
                <span class="text-light text-decoration-underline text-decoration-none">Sidebar</span>
            </div>
            <ul>
                <li class="my-3"><a href="" class="text-light text-decoration-none">Layouting</a></li>
                <li class="my-3"><a href="" class="text-light text-decoration-none">Operator</a></li>
                <li class="my-3"><a href="" class="text-light text-decoration-none">Management</a></li>
                <li class="my-3"><a href="" class="text-light text-decoration-none">Settings</a></li>
                <li class="my-3"><a href="" class="text-light text-decoration-none">Report</a></li>
            </ul>
        </div>
    </div>
    <script>
        let token = localStorage.getItem("token");
        if(token==null) {
            token = "${savedUser.data.token}"
        }
        localStorage.setItem("token",token);
    </script>
    </body>
</html>
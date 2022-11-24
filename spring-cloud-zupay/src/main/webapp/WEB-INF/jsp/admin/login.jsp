<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login Administrator</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <script src="<%=request.getContextPath()%>/webjars/sweetalert2/11.4.33/dist/sweetalert2.all.min.js"></script>
    <script src="<%=request.getContextPath()%>/webjars/jquery/3.6.1/dist/jquery.min.js"></script>
</head>
<body>
<div class="row h-100">
    <div class="col-7 bg-success bg-gradient d-flex align-items-center justify-content-center">
        <h1 class="text-light display-6 text-decoration-underline" style="text-underline-offset: 10px;">TOPAS CENTER ADMINISTRATOR</h1>
    </div>
    <div class="col-5 bg-light d-flex align-items-center">
        <div class="bg-light">
            <%--@elvariable id="login" type=""--%>
            <%--@elvariable id="loginModel" type=""--%>
            <form:form method="post" action="${pageContext.request.contextPath}/admin/login" modelAttribute="loginModel">
                <%--@declare id="exampleinputemail"--%><%--@declare id="exampleinputpassword"--%>
                <div class="row p-3">
                    <h2 class="mb-3 text-muted"><a>Sign In</a></h2>
                    <div class="col-3">
                        <label for="exampleInputEmail" class="form-label text-dark">Username</label>
                    </div>
                    <div class="col-9 mb-3">
                        <form:input type="email" class="form-control" value="username" path="username"/>
                    </div>
                    <div class="col-3">
                        <label for="exampleinputPassword" class="form-label text-dark">Password</label>
                    </div>
                    <div class="col-9 mb-3">
                        <form:input type="password" class="form-control" value="password" path="password"/>
                    </div>
                    <input type="submit" id="ok" class="btn btn-danger mt-3" value="Submit"></input>
                    <span class="text-muted mt-2"><a href="#">Forgot your password?</a></span>
                </div>
            </form:form>
        </div>
    </div>

</div>
</body>

<script>
    $("#ok").click(function(event) {
        Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Your successfully login',
            showConfirmButton: false
        })
        event.preventDefault();
        window.location.replace(window.location.protocol + "//" + window.location.host+"/demo/admin/homepage");
    })

</script>

</html>
<%--
  Created by IntelliJ IDEA.
  User: vishwa_p
  Date: 9/3/2020
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Fail</title>
    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper" style="background-image: url('images/bg-registration-form-2.jpg');">
    <div class="inner">
        <div class="image-holder">
            <img src="images/authorization-icon-19.jpg" alt="">
        </div>
        <form action="LogOutServlet" method="get">
            <button>Log In Again
                <i class="zmdi zmdi-arrow-right"></i>
            </button>
        </form>
    </div>
</div>

</body>
</html>

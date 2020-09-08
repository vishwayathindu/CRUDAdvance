<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vishwa_p
  Date: 9/4/2020
  Time: 7:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper" style="background-image: url('images/bg-registration-form-2.jpg');">
    <div class="inner">
        <div class="image-holder">
            <img src="images/registration-form-6.png" alt="">
        </div>
        <form action="RemoveServlet" method="post">
            <h3>Delete User Details</h3>
            <div class="form-wrapper">
                <input type="text" placeholder="ID" class="form-control" name="ID" value="<c:out value="${st.id}"/>"
                       readonly>
                <i class="zmdi zmdi-account"></i>
            </div>
            <div class="form-wrapper">
                <input type="text" placeholder="Username" class="form-control" name="UserName"
                       value="<c:out value="${st.userName}"/>" readonly>
                <i class="zmdi zmdi-account"></i>
            </div>
            <div class="form-wrapper">
                <input type="text" placeholder="NIC" class="form-control" name="nic" value="<c:out value="${st.nic}"/>"
                       readonly>
                <i class="zmdi zmdi-card"></i>
            </div>
            <div class="form-wrapper">
                <input type="text" placeholder="Mobile Number" class="form-control" name="mobileNumber"
                       value="<c:out value="${st.mobileNumber}"/>" readonly>
                <i class="zmdi zmdi-phone"></i>
            </div>
            <div class="form-wrapper">
                <select name="gender" class="form-control" value="<c:out value="${st.gender}"/>" readonly>
                    <option value="male">Male</option>
                    <option value="femal">Female</option>
                </select>
                <i class="zmdi zmdi-caret-down" style="font-size: 17px"></i>
            </div>
            <button>Delete
                <i class="zmdi zmdi-arrow-right"></i>
            </button>
        </form>
    </div>
</div>

</body>
</html>

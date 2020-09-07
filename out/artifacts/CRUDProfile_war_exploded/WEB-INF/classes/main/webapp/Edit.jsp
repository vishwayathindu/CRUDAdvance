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
    <title>$Title$</title>
    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
  <div class="wrapper" style="background-image: url('images/bg-registration-form-2.jpg');">
    <div class="inner">
      <div class="image-holder">
        <img src="images/registration-form-5.png" alt="">
      </div>
      <form action="UpdateServlet" method="post">
        <h3>User Update Form</h3>
        <div class="form-wrapper">
          <input type="text" placeholder="ID" class="form-control" name="ID" value="<c:out value="${st.id}"/>" readonly>
          <i class="zmdi zmdi-account"></i>
        </div>
        <div class="form-wrapper">
          <input type="text" placeholder="Username" class="form-control" name="UserName" value="<c:out value="${st.userName}"/>"required maxlength="255">
          <i class="zmdi zmdi-account"></i>
        </div>
        <div class="form-wrapper">
          <input type="text" placeholder="NIC" class="form-control" name="nic" value="<c:out value="${st.nic}"/>" minlength="10" maxlength="12" pattern="^([0-9]{9}[x|X|v|V]|[0-9]{12})$" required>
          <i class="zmdi zmdi-card"></i>
        </div>
        <div class="form-wrapper">
          <input type="text" placeholder="Mobile Number" class="form-control" name="mobileNumber" value="<c:out value="${st.mobileNumber}"/>" minlength="10" maxlength="12" pattern="^(?:0|94|\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|5|6|7|8)\d)\d{6}$" required>
          <i class="zmdi zmdi-phone"></i>
        </div>
        <div class="form-wrapper">
          <select name="gender"  class="form-control" value="<c:out value="${st.gender}"/>" required>
            <option value="male">Male</option>
            <option value="femal">Female</option>
          </select>
          <i class="zmdi zmdi-caret-down" style="font-size: 17px"></i>
        </div>
        <button>Update
          <i class="zmdi zmdi-arrow-right"></i>
        </button>
      </form>
    </div>
  </div>

  </body>
</html>

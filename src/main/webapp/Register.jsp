<%--
  Created by IntelliJ IDEA.
  User: vishwa_p
  Date: 9/3/2020
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>User Register Servlet</title>
    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="wrapper" style="background-image: url('images/bg-registration-form-2.jpg');">
    <div class="inner">
        <div class="image-holder">
            <img src="images/registration-form-3.png" alt="">
        </div>
        <form action="RegisterUserServlet" method="post">
            <h3>Registration Form</h3>
            <div class="form-wrapper">
                <input type="text" placeholder="Username" class="form-control" name="UserName" required maxlength="255">
                <i class="zmdi zmdi-account"></i>
            </div>
            <div class="form-wrapper">
                <input type="text" placeholder="NIC" class="form-control" name="nic" minlength="10" maxlength="12"
                       pattern="^([0-9]{9}[x|X|v|V]|[0-9]{12})$" required>
                <i class="zmdi zmdi-card"></i>
            </div>
            <div class="form-wrapper">
                <input type="text" placeholder="Mobile Number" class="form-control" name="mobileNumber" minlength="10"
                       maxlength="12"
                       pattern="^(?:0|94|\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|5|6|7|8)\d)\d{6}$"
                       required>
                <i class="zmdi zmdi-phone"></i>
            </div>
            <div class="form-wrapper">
                <select name="gender" class="form-control" required>
                    <option value="" disabled selected>Gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                </select>
                <i class="zmdi zmdi-caret-down" style="font-size: 17px"></i>
            </div>
            <div class="form-wrapper">
                <input type="password" placeholder="Password" class="form-control" name="password"
                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[!@#$%^&*])(?=.*[A-Z]).{8,}" required>
                <i class="zmdi zmdi-lock"></i>
            </div>
            <div class="form-wrapper">
                <input type="password" placeholder="Confirm Password" class="form-control" name="confirmPass"
                       pattern="(?=.*\d)(?=.*[a-z])(?=.*[!@#$%^&*])(?=.*[A-Z]).{8,}" required>
                <i class="zmdi zmdi-lock"></i>
            </div>
            <button>Register
                <i class="zmdi zmdi-arrow-right"></i>
            </button>
        </form>
    </div>
</div>


</body>
</html>

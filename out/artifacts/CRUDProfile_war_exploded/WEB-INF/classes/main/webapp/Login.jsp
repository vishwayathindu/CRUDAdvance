<%--
  Created by IntelliJ IDEA.
  User: vishwa_p
  Date: 9/3/2020
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Login</title>
    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/capture.css">

</head>
<body>
<div class="wrapper" style="background-image: url('images/bg-registration-form-2.jpg');">
    <div class="inner">
        <div class="image-holder">
            <img src="images/registration-form-4.jpg" alt="">
        </div>
        <form action="LoginServlet" method="post" onsubmit="return checkform(this);">
            <h3>Login Form</h3>
            <div class="form-wrapper">
                <input type="text" placeholder="Username" class="form-control" name="UserName">
                <i class="zmdi zmdi-account"></i>
            </div>
            <div class="form-wrapper">
                <input type="password" placeholder="Password" class="form-control" name="confirmPass">
                <i class="zmdi zmdi-lock"></i>
            </div>

            <div class="capbox">

                <div id="CaptchaDiv"></div>

                <div class="capbox-inner">
                    Type the number:<br>

                    <input type="hidden" id="txtCaptcha">
                    <input type="text" name="CaptchaInput" id="CaptchaInput" size="15"><br>

                </div>
            </div>
            <button>Log In
                <i class="zmdi zmdi-arrow-right"></i>
            </button>
            <a href="Register.jsp">sign up</a>
        </form>
    </div>
</div>
<script type="text/javascript">

    // Captcha Script

    function checkform(theform) {
        var why = "";

        if (theform.CaptchaInput.value == "") {
            why += "- Please Enter CAPTCHA Code.\n";
        }
        if (theform.CaptchaInput.value != "") {
            if (ValidCaptcha(theform.CaptchaInput.value) == false) {
                why += "- The CAPTCHA Code Does Not Match.\n";
            }
        }
        if (why != "") {
            alert(why);
            return false;
        }
    }

    var a = Math.ceil(Math.random() * 9) + '';
    var b = Math.ceil(Math.random() * 9) + '';
    var c = Math.ceil(Math.random() * 9) + '';
    var d = Math.ceil(Math.random() * 9) + '';
    var e = Math.ceil(Math.random() * 9) + '';

    var code = a + b + c + d + e;
    document.getElementById("txtCaptcha").value = code;
    document.getElementById("CaptchaDiv").innerHTML = code;

    // Validate input against the generated number
    function ValidCaptcha() {
        var str1 = removeSpaces(document.getElementById('txtCaptcha').value);
        var str2 = removeSpaces(document.getElementById('CaptchaInput').value);
        if (str1 == str2) {
            return true;
        } else {
            return false;
        }
    }

    // Remove the spaces from the entered and generated code
    function removeSpaces(string) {
        return string.split(' ').join('');
    }
</script>
</body>
</html>

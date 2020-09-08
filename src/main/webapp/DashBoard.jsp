<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vishwa_p
  Date: 9/3/2020
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Dashboard</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->
    <!-- MATERIAL DESIGN ICONIC FONT -->
    <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

    <!-- STYLE CSS -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%
    //redirect user to login page if not logged in
    try {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        if (session.getAttribute("Id") == null) {
            response.sendRedirect("Login.jsp");
        }
    } catch (Exception ex) {
        out.println(ex);
    }
%>
<%--log out button--%>
<form action="LogOutServlet">
    <button style="position:absolute; right: 10px">Log Out
        <i class="zmdi zmdi-arrow-right"></i>
    </button>
</form>
<div class="limiter" style="position:absolute; top:100px">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100 ver1 m-b-110">
<%--            table headings with sort buttons--%>
                <div class="table100-head">
                    <table>
                        <thead>
                        <tr class="row100 head" style="cursor: pointer">
                            <th class="cell100 column1" onclick="sortTable(0)">User Name<i
                                    class="zmdi zmdi-unfold-more"></i></th>
                            <th class="cell100 column2" onclick="sortTable(1)">ID<i
                                    class="zmdi zmdi-unfold-more"></i></th>
                            <th class="cell100 column3" onclick="sortTable(2)">NIC<i
                                    class="zmdi zmdi-unfold-more"></i></th>
                            <th class="cell100 column4" onclick="sortTable(3)">Mobile Number<i
                                    class="zmdi zmdi-unfold-more"></i></th>
                            <th class="cell100 column5" onclick="sortTable(4)">Gender<i
                                    class="zmdi zmdi-unfold-more"></i></th>
                            <th class="cell100 column6">Edit/Delete</th>
                        </tr>
                        </thead>
                    </table>
                </div>
<%--            search Button--%>
                <div class="table100-body js-pscroll">
                    <table>
                        <th class="cell100 column1" colspan="6">
                            <table cellpadding="5" cellspacing="5">
                                <tr>
                                    <td colspan="5">
                                        <form action="SearchServlet" method="get">
                                            <label style="color: white">Search user:</label>
                                            <input type="text" name="searchValue" placeholder="Name,NIC,mobile number or gender "
                                                   class="form-control" value="<c:out value="${userName}"/>">
                                            <button type="submit" name="searchUser"
                                                     class="btn btn-primary btn-block btn-large">Search<i
                                                    class="zmdi zmdi-search"></i></button>
                                        </form>
                                    </td>
                                </tr>
                            </table>
                        </th>
                    </table>
                </div>
<%--            table body --%>
                <div class="table100-body js-pscroll">
                    <table id="myTable">
                        <tbody>
                        <c:forEach var="listOfAcc" items="${listUser}">

                            <tr class="row100 body">
                                <td class="cell100 column1"><c:out value="${listOfAcc.userName}"/></td>
                                <td class="cell100 column2"><c:out value="${listOfAcc.id}"/></td>
                                <td class="cell100 column3"><c:out value="${listOfAcc.nic}"/></td>
                                <td class="cell100 column4"><c:out value="${listOfAcc.mobileNumber}"/></td>
                                <td class="cell100 column5"><c:out value="${listOfAcc.gender}"/></td>
                                <td class="cell100 column6">
                                    <a class="btn btn-sm btn-success"
                                       href="EditServlet?Id=<c:out value="${listOfAcc.id}"/>"><i
                                            class="zmdi zmdi-edit"></i>Edit</a><br/><br/>
                                    <a class="btn btn-sm btn-danger"
                                       href="DeleteServlet?Id=<c:out value="${listOfAcc.id}"/>"><i
                                            class="zmdi zmdi-delete"></i>Delete</a>
                                </td>

                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>

                </div>
<%--            data downloding buttons and upload button--%>
                <div class="table100-body js-pscroll">
                    <table>
                        <th class="cell100 column1" colspan="6">
                            <table cellpadding="5" cellspacing="5">
                                <tr>
                                    <td>
                                        <form action="PdfServlet">
                                            <button>PDF Download
                                                <i class="zmdi zmdi-arrow-right"></i>
                                            </button>

                                        </form>
                                    <td>
                                    <td>
                                        <form action="ExcelServlet">
                                            <button>Excel Download
                                                <i class="zmdi zmdi-arrow-right"></i>
                                            </button>

                                        </form>
                                    </td>
                                    <td>
                                        <form action="uploadServlet">
                                            <button>upload
                                                <i class="zmdi zmdi-arrow-right"></i>
                                            </button>

                                        </form>
                                    </td>


                                </tr>
                            </table>
                        </th>
                    </table>
                </div>
<%--            pagination page numbers--%>
                <div class="">
                    <table>
                        <th></th>
                        <th class="" >
                            <table cellpadding="5" cellspacing="5">
                                <tr>
                                    <c:forEach begin="1" end="${noOfPages}" var="i">
                                        <c:choose>
                                            <c:when test="${currentPage eq i}">
                                                <td class="" style="color: white">${i}</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td class=""><a href="DashBoardServlet?pageId=${i}&sort=${columnName}"
                                                                style="color: white">${i}</a></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </tr>
                            </table>
                        </th>
                        <th></th>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>
<%--sorting function --%>
<script>
    function sortTable(n) {
        var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
        table = document.getElementById("myTable");
        switching = true;
        //Set the sorting direction to ascending:
        dir = "asc";
        /*Make a loop that will continue until
        no switching has been done:*/
        while (switching) {
            //start by saying: no switching is done:
            switching = false;
            rows = table.rows;
            /*Loop through all table rows (except the
            first, which contains table headers):*/
            for (i = 0; i < (rows.length - 1); i++) {
                //start by saying there should be no switching:
                shouldSwitch = false;
                /*Get the two elements you want to compare,
                one from current row and one from the next:*/
                x = rows[i].getElementsByTagName("TD")[n];
                y = rows[i + 1].getElementsByTagName("TD")[n];
                /*check if the two rows should switch place,
                based on the direction, asc or desc:*/
                if (dir == "asc") {
                    if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                        //if so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                } else if (dir == "desc") {
                    if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                        //if so, mark as a switch and break the loop:
                        shouldSwitch = true;
                        break;
                    }
                }
            }
            if (shouldSwitch) {
                /*If a switch has been marked, make the switch
                and mark that a switch has been done:*/
                rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                switching = true;
                //Each time a switch is done, increase this count by 1:
                switchcount++;
            } else {
                /*If no switching has been done AND the direction is "asc",
                set the direction to "desc" and run the while loop again.*/
                if (switchcount == 0 && dir == "asc") {
                    dir = "desc";
                    switching = true;
                }
            }
        }
    }
</script>


</body>
</html>


package controller;

import dao.DAO;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int ID= Integer.parseInt(request.getParameter("ID"));
        String UserName= request.getParameter("UserName");
        String nic= request.getParameter("nic");
        String mobileNumber= request.getParameter("mobileNumber");
        String gender= request.getParameter("gender");

        // matching nic
        Pattern patt = Pattern.compile("^([0-9]{9}[x|X|v|V]|[0-9]{12})$");
        Matcher nicM = patt.matcher(nic);
        boolean matches = nicM.matches();

        //matching mobile number
        Pattern mob = Pattern.compile("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|5|6|7|8)\\d)\\d{6}$");
        Matcher mobM = mob.matcher(mobileNumber);
        boolean mobMatches = mobM.matches();


        if (UserName == "" || nic == "") {
//            System.out.printf("student name"+ studentName);
            RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFail.jsp");
            dispatcher.forward(request, response);
        } else if (!matches == true) {
//            System.out.println("nic did n't matches"+matches);
            RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFail.jsp");
            dispatcher.forward(request, response);

        } else if (!mobMatches == true) {
//            System.out.println("password did n't matches "+passMatches);
            RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFail.jsp");
            dispatcher.forward(request, response);

        } else {

            Model s1 = new Model();
            s1.setId(ID);
            s1.setUserName(UserName);
            s1.setNic(nic);
            s1.setMobileNumber(mobileNumber);
            s1.setGender(gender);

            try {
                int results = DAO.Updated(s1);
                System.out.printf("studenent update working results" + results);
                response.sendRedirect(request.getContextPath() + "/DashBoardServlet");

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

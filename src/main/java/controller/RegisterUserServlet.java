package controller;

import dao.DAO;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@WebServlet(name = "RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Creating user variables
        String userName = request.getParameter("UserName");
        String nic = request.getParameter("nic");
        String mobileNumber = request.getParameter("mobileNumber");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String conPassword = request.getParameter("confirmPass");

        // matching nic
        Pattern patt = Pattern.compile("^([0-9]{9}[x|X|v|V]|[0-9]{12})$");
        Matcher nicM = patt.matcher(nic);
        boolean matches = nicM.matches();

        //matching password
        Pattern pass = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[!@#$%^&*])(?=.*[A-Z]).{8,}");
        Matcher passM = pass.matcher(password);
        boolean passMatches = passM.matches();

        //matching mobile number
        Pattern mob = Pattern.compile("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|5|6|7|8)\\d)\\d{6}$");
        Matcher mobM = mob.matcher(mobileNumber);
        boolean mobMatches = mobM.matches();

//        System.out.println("nic matches"+matches);
//        System.out.println("password matches"+passMatches);

        if (userName == "" || nic == "") {
//            System.out.printf("student name"+ studentName);
            RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFail.jsp");
            dispatcher.forward(request, response);
        } else if (!matches == true) {
//            System.out.println("nic did n't matches"+matches);
            RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFail.jsp");
            dispatcher.forward(request, response);

        } else if (!passMatches == true) {
//            System.out.println("password did n't matches "+passMatches);
            RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFail.jsp");
            dispatcher.forward(request, response);

        } else if (!mobMatches == true) {
//            System.out.println("password did n't matches "+passMatches);
            RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFail.jsp");
            dispatcher.forward(request, response);

        } else if (!password.equals(conPassword)) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFail.jsp");
            dispatcher.forward(request, response);
        } else {

            Model s1 = new Model(0, userName, nic, mobileNumber, gender, password);
            try {
                int result = DAO.registerUser(s1);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
                System.out.println(result);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            //System.out.printf("new user added" + result);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

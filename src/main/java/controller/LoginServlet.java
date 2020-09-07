package controller;

import dao.DAO;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserName = request.getParameter("UserName");
        String  confirmPass = request.getParameter("confirmPass");

        System.out.println("capture data" + UserName + " " + confirmPass);

        //creating the object
        Model s1 = new Model();
        s1.setUserName(UserName);
        s1.setPassword(confirmPass);

        try {
            Model s2 = DAO.Login(s1);
            int id = s2.getId();
            if (id == 0) {
                System.out.println("login fail");
                RequestDispatcher dispatcher = request.getRequestDispatcher("LoginFail.jsp");
                dispatcher.forward(request, response);
            } else {
                //System.out.printf("student log in success" + result);


                HttpSession session = request.getSession(true);
                session.setAttribute("Id", id);
                response.sendRedirect(request.getContextPath() + "/DashBoardServlet?pageId=1&sort=id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

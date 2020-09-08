package controller;

import dao.DAO;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
        String userName = request.getParameter("searchValue");
        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("Id");
        List<Model> listUser = null;

        if (userName == "") {
            response.sendRedirect(request.getContextPath() + "/DashBoardServlet?pageId=1&sort=id");
        } else {
            try {

                listUser = dao.search(userName, id);
                request.setAttribute("listUser", listUser);
                request.setAttribute("userName", userName);
                RequestDispatcher dispatcher = request.getRequestDispatcher("DashBoard.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}

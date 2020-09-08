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

//@WebServlet(name = "DashBoardServlet")
public class DashBoardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        DAO dao = new DAO();
        HttpSession session = request.getSession(false);
        int id = (int) session.getAttribute("Id");
        int pageid = Integer.parseInt(request.getParameter("pageId"));
        String sort = request.getParameter("sort");

        int total = 5;
        if (pageid == 1) {
        } else {
            pageid = pageid - 1;
            pageid = pageid * total + 1;
        }

        if (id != 0) {
            if (!sort.equals("userName")) {

                int noOfRecords = DAO.NoOfRecords();
                int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / total);
                String columnName = "Id";
                List<Model> listUser = null;
                try {
                    listUser = DAO.getRecords(pageid, total, columnName, id);
                    request.setAttribute("listUser", listUser);
                    request.setAttribute("noOfPages", noOfPages);
                    request.setAttribute("currentPage", pageid);
                    request.setAttribute("columnName", columnName);

                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } else {

                int noOfRecords = DAO.NoOfRecords();
                int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / total);
                String columnName = "userName";
                List<Model> listUser = null;
                try {
                    listUser = DAO.getRecords(pageid, total, columnName, id);
                    request.setAttribute("listUser", listUser);
                    request.setAttribute("noOfPages", noOfPages);
                    request.setAttribute("currentPage", pageid);
                    request.setAttribute("columnName", columnName);


                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("DashBoard.jsp");
            dispatcher.forward(request, response);
        } else {

            request.getRequestDispatcher("Login.jsp").include(request, response);

        }


    }
}

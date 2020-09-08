package controller;

import dao.DAO;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int Id = Integer.parseInt(request.getParameter("Id"));


        Model s1 = new Model();
        s1.setId(Id);
        DAO st = new DAO();
        try {

            Model st2 = st.editList(s1);

            System.out.println("user update servelt pass data and retrive st2");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Delete.jsp");
            request.setAttribute("st", st2);
            dispatcher.forward(request, response);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

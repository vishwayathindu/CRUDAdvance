package controller;

import dao.DAO;
import model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RemoveServlet")
public class RemoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("ID"));
        Model st = new Model();
        st.setId(ID);
        //System.out.println("user name need to delete the data" + stName);

        try {

            int result = DAO.delete(st);
            //System.out.printf("user delete servelet executed" + result);
            response.sendRedirect(request.getContextPath() + "/DashBoardServlet?pageId=1&sort=id");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

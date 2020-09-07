package controller;

import dao.DAO;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet(name = "uploadServlet")
public class uploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reportPath = request.getServletContext().getRealPath("WEB-INF") + "\\uploadDoc.csv";
        int batchSize = 20;
        BufferedReader lineReader = new BufferedReader(new FileReader(reportPath));
        String lineText = null;

        int count = 0;

        lineReader.readLine(); // skip header line

        while ((lineText = lineReader.readLine()) != null) {
            String[] data = lineText.split(",");
            String userName = data[0];
            String nic = data[1];
            String mobileNumber = data[2];
            String gender = data[3];
            String password = data[4];

            Model s1 = new Model(0, userName, nic, mobileNumber, gender, password);
            try {
                int result = DAO.registerUser(s1);
                System.out.println(result);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
        dispatcher.forward(request, response);
    }
}

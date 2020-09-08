package controller;

import dao.DAO;
import model.Model;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

//@WebServlet(name = "PdfServlet")
public class PdfServlet extends HttpServlet {
    private final String DOWNLOAD_FILE_NAME = "postReport.pdf"; //file name of the downloadable file
    private final String FILE_TYPE = "application/pdf"; //file type of the file(pdf)

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Model> postData;
        String reportPath;
        OutputStream outputStream = null;
        JasperReport jasperReport;
        JasperDesign jasperDesign;
        JRDataSource reportSource;
        Map reportParameters;
        DAO dao = new DAO();

        try {

            reportPath = request.getServletContext().getRealPath("WEB-INF/ireport") + "\\report2.jrxml";

            reportParameters = new HashMap();
            reportParameters.put("userName", "userName ");

            jasperDesign = JRXmlLoader.load(reportPath);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);

            postData = dao.getAllRecords();
            reportSource = new JRBeanCollectionDataSource(postData); //set the database values to the reportSource

            //byteStream
            byte[] byteStream;
            byteStream = JasperRunManager.runReportToPdf(jasperReport, reportParameters, reportSource);

            //response
            response.setHeader("Content-Disposition", "attachement; filename=" + DOWNLOAD_FILE_NAME);
            response.setContentType(FILE_TYPE);
            response.setContentLength(byteStream.length);

            //outputstream
            outputStream = response.getOutputStream();

            //byteStream = data, 0 = starting offset, byteStream.length = length
            outputStream.write(byteStream, 0, byteStream.length);

        } catch (JRException ex) {
            Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(PdfServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        response.sendRedirect(request.getContextPath() + "/DashBoardServlet?pageId=1&sort=id");
    }
}

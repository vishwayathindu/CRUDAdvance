package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection get;
    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3307/crudapplication";
    private static final String user = "root";
    private static final String password = "";
    private static final String driver = "com.mysql.jdbc.Driver";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, user, password);
        //System.out.println("dabase connection success");
        return connection;
    }
}

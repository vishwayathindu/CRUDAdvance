package dao;

import db.DbConnection;
import model.Model;
import util.Hash;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    public static int registerUser(Model s1) throws SQLException, NoSuchAlgorithmException {
        int result = 0;
        Connection connection = null;
        PreparedStatement PreparedStatement = null;
        Hash hash = new Hash();
        String sql = "INSERT INTO usertable (userName, nic, mobileNumber, gender, password) VALUES (?,?,?,?,?)";

        try {
            connection = new DbConnection().getConnection();
            String password = new Hash().hashPassword(Model.getPassword());
            PreparedStatement = connection.prepareStatement(sql);
            PreparedStatement.setString(1, s1.getUserName());
            PreparedStatement.setString(2, s1.getNic());
            PreparedStatement.setString(3, s1.getMobileNumber());
            PreparedStatement.setString(4, s1.getGender());
            PreparedStatement.setString(5, password);
            result = PreparedStatement.executeUpdate();
            return result;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return result;
        } finally {
            if (PreparedStatement != null) {
                PreparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }


    }

    public static Model Login(Model s1) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM `usertable` WHERE userName= ? and password = ?";


        try {
            connection = new DbConnection().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            String password = new Hash().hashPassword(Model.getPassword());

            //System.out.println("student login stared working" + password);

            preparedStatement.setString(1, s1.getUserName());
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int Id = resultSet.getInt("id");
                s1 = new Model();
                s1.setId(Id);

            } else {
                s1 = new Model();
                s1.setId(0);

            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }


        return s1;
    }

    public static int NoOfRecords() {
        int noOfRecords = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "select count(*) from usertable";
        try {
            connection = new DbConnection().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                noOfRecords = resultSet.getInt(1);
                //System.out.println(noOfRecords);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return noOfRecords;
    }

    public static List<Model> getRecords(int start, int total, String columnName, int id) throws SQLException, ClassNotFoundException {
        List<Model> user = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from usertable where Id != " + id + " ORDER BY " + columnName + " DESC limit " + (start - 1) + "," + total;

        try {
            connection = new DbConnection().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String userName = rs.getString("userName");
                String nic = rs.getString("nic");
                String mobileNumber = rs.getString("mobileNumber");
                String gender = rs.getString("gender");
                String password = rs.getString("password");
                user.add(new Model(Id, userName, nic, mobileNumber, gender, password));

                //System.out.println("data return" + studentId + "" + StudentName + "" + nIC + "" + password + "" + gender);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
        return user;
    }

    public static int Updated(Model s1) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {

        int result = 0;
        Connection connection = null;
        PreparedStatement PreparedStatement = null;
        String sql = "UPDATE usertable SET userName= ?,nic= ?,mobileNumber= ?, gender=? WHERE id= ?";

        try {
            connection = new DbConnection().getConnection();
            PreparedStatement = connection.prepareStatement(sql);
            PreparedStatement.setString(1, s1.getUserName());
            PreparedStatement.setString(2, s1.getNic());
            PreparedStatement.setString(3, s1.getMobileNumber());
            PreparedStatement.setString(4, s1.getGender());
            PreparedStatement.setInt(5, s1.getId());
            result = PreparedStatement.executeUpdate();
            System.out.println("student updated working");
            return result;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    public static int delete(Model s1) throws SQLException {
        int result = 0;
        Connection connection = null;
        PreparedStatement PreparedStatement = null;
        String sql = "DELETE  FROM `usertable` WHERE id = ? ";

        try {
            connection = new DbConnection().getConnection();
            PreparedStatement = connection.prepareStatement(sql);
            PreparedStatement.setInt(1, s1.getId());
            result = PreparedStatement.executeUpdate();
            //System.out.printf("delte function got executed" + result);
            return result;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (PreparedStatement != null) {
                PreparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }


        return result;
    }

    public List<Model> getAllRecords() throws SQLException {
        List<Model> user = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        final String sql = "select * from usertable";

        try {
            connection = new DbConnection().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String userName = rs.getString("userName");
                String nic = rs.getString("nic");
                String mobileNumber = rs.getString("mobileNumber");
                String gender = rs.getString("gender");
                String password = rs.getString("password");
                user.add(new Model(Id, userName, nic, mobileNumber, gender, password));

//                System.out.println("data return"+studentId+""+StudentName+""+nIC+""+password+""+gender);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
        return user;


    }

    public List<Model> search(String Name, int id) throws SQLException {
        List<Model> user = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        final String sql = "select * from usertable where (userName  like  '" + Name + "%' or nIC like  '" + Name + "%') and Id !=" + id + "";
        //System.out.printf("searched student name is"+stName);

        try {
            connection = new DbConnection().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String userName = rs.getString("userName");
                String nic = rs.getString("nic");
                String mobileNumber = rs.getString("mobileNumber");
                String gender = rs.getString("gender");
                String password = rs.getString("password");
                user.add(new Model(Id, userName, nic, mobileNumber, gender, password));

                //System.out.println("data return" + studentId + "" + StudentName + "" + nIC + "" + password + "" + gender);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            //System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }

        }
        return user;


    }

    public Model editList(Model s1) throws SQLException, ClassNotFoundException {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        final String sql = "select * from usertable where Id= ?";

        try {
            connection = new DbConnection().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, s1.getId());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int Id = rs.getInt("Id");
                String userName = rs.getString("userName");
                String nic = rs.getString("nic");
                String mobileNumber = rs.getString("mobileNumber");
                String gender = rs.getString("gender");
                String password = rs.getString("password");
                s1 = new Model(Id, userName, nic, mobileNumber, gender, password);


            }
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }


        return s1;
    }


}

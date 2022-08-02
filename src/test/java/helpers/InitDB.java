package helpers;
/////////correct connection

import java.sql.*;

public class InitDB {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    Connection con = null;
    Statement stmt = null;

    String userName = "root";
    String password = "tesvan123###";
    String yourDatabaseName = "Rest_Assured_GorestDB";
    public  void initJDBC(){
        //Register JDBC
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC not registered!!");

        }
    }
    //-----------------------------------------------------------
    public void connectDB(String url) {
        this.initJDBC();
        try {
            con = DriverManager.getConnection(url, userName, password);
            if (con != null) System.out.println("Connected to DB!!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Connection break!!!");
        }
    }
        //----------------------------------------------------------------------

        public void createDB(){
        //Create DB
        String url = "jdbc:mysql://localhost:3306";
        this.connectDB(url);
        try{
            stmt = con.createStatement();
            int status = stmt.executeUpdate("CREATE DATABASE if not exists " + yourDatabaseName);
            if (status > 0) {
                System.out.println("Database is created successfully !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //--------------------------------------------------------------------
    public void createTable() {
        //Create Table
        String url = "jdbc:mysql://localhost:3306/Rest_Assured_GorestDB";//I can't use variable in url path
        this.initJDBC();
        this.connectDB(url);
        try {
            stmt = con.createStatement();
            String query = "CREATE TABLE if not exists users("+
                    "id INTEGER not null AUTO_INCREMENT," +
                    "name VARCHAR(255)," +
                    "gender VARCHAR(255)," +
                    "email VARCHAR(255)," +
                    "status VARCHAR(255)," +
                    "PRIMARY KEY(id))";
            stmt.executeUpdate(query);
            System.out.println("Table created successfully!!!");

        } catch (SQLException e) {
            System.out.println("Table cannot be created!");
            return;
        }
    }

}

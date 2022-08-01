package helpers;
/////////correct connection

import java.sql.*;

public class CreateDatabaseDemo {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public void init(){
        //Register JDBC
        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            System.out.println("JDBC not registered!!");
            return;
        }

        //Connect to the DB and create DB
        Connection con = null;
        Statement stmt = null;

        String url = "jdbc:mysql://localhost:3306";
        String userName = "root";
        String password = "tesvan123###";
        String yourDatabaseName = "Rest_Assured_DB_Gorest9 ";
        try {
            con = DriverManager.getConnection(url, userName, password);
            stmt = con.createStatement();
            int status = stmt.executeUpdate("CREATE DATABASE " + yourDatabaseName);
            if (status > 0) {
                System.out.println("Database is created successfully !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Create Table

            try {
                stmt = con.createStatement();
                String sql = "CREATE TABLE users(id INTEGER not null AUTO_INCREMENT, " +
                        "name VARCHAR(255)," +
                        "gender VARCHAR(255)," +
                        "email VARCHAR(255)," +
                        "status VARCHAR(255)," +
                        "PRIMARY KEY(id))";
                stmt.executeUpdate(sql);
            }catch (SQLException e){
                System.out.println("Table cannot be created!");
                return;
            }
            System.out.println("Table created successfully!!!");

    }
}

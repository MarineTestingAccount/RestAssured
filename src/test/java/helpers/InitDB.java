package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static helpers.ConstData.*;

public class InitDB {
        Connection con = null;
        Statement stmt = null;

        //Register JDBC
        public void initJDBC() {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC cannot be registered!!");
            }
        }

        //Connect to the Instance
        public void connectDB(String url) {
            this.initJDBC();
            try {
                con = DriverManager.getConnection(url, ROOT_USER_NAME, ROOT_PASSWORD);
                if (con != null) System.out.println("Connected to Instance!!!");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Cannot be connected to the Instance!!!");
            }
        }

        //CreateDB
        public void createDB() {
            this.connectDB(LOCAL_INSTANCE_URL);
            try {
                stmt = con.createStatement();
                int status = stmt.executeUpdate("CREATE DATABASE if not exists " + LOCAL_DB_NAME);
                if (status > 0) {
                    System.out.println("Database is created successfully !!!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Database cannot be created!!");
            }
        }

        //Create Table
        public void createTable() {
            this.initJDBC();
            this.connectDB(LOCAL_DB_URL);
            try {
                stmt = con.createStatement();
                String query = "CREATE TABLE if not exists users(" +
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

            }
        }

//    //Insert values via JDBC
//    public void insertValues(String nameV, String genderV, String emailV, String statusV) {
//        String url = "jdbc:mysql://localhost:3306/Rest_Assured_GorestDB";//I can't use variable in url path
//        this.initJDBC();
//        this.connectDB(url);
//
//        String sql = " insert into users (name, gender, email, status)"
//                + " values (?,?,?,?)";
//
//
//        try {
//            stmt = con.createStatement();
//            int i = stmt.executeUpdate(sql);
//            if (i > 0) {
//                System.out.println("ROW INSERTED");
//            } else {
//                System.out.println("ROW NOT INSERTED");
//            }
//        } catch (Exception e) {
//            System.err.println("Got an exception!");
//            e.printStackTrace();
//        }
//
//    }

    }


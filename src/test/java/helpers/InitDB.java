package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static helpers.ConstData.*;

public class InitDB {
        static Connection con = null;
        static Statement stmt = null;

        //Register JDBC
        public static void initJDBC() {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC cannot be registered!!");
            }
        }

        //Connect to the Instance
        public static void connectDB(String url) {
            initJDBC();
            try {
                con = DriverManager.getConnection(url, ROOT_USER_NAME, ROOT_PASSWORD);
                if (con != null) System.out.println("Connected to Instance!!!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Cannot be connected to the Instance!!!");
            }
        }

        //CreateDB
        public static void createDB() {
            connectDB(LOCAL_INSTANCE_URL);
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
        public static void createTable() {
            initJDBC();
            connectDB(LOCAL_INSTANCE_URL + LOCAL_DB_URL);
            try {
                stmt = con.createStatement();
                String query = "CREATE TABLE if not exists users(" +
                        "id INTEGER not null," +
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

    //Insert values via JDBC
    public void insertValues(int idVal, String nameVal, String genderVal, String emailVal, String statusVal) {
//        String url = LOCAL_INSTANCE_URL + LOCAL_DB_URL;
//        this.initJDBC();
//        this.connectDB(url);

        String sql = " insert into users (id, name, gender, email, status)"
                + " values (idVal, {nameVal}, {genderVal}, {emailVal}, {statusVal})";


        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate(sql);
            if (i > 0) {
                System.out.println("ROW INSERTED");
            } else {
                System.out.println("ROW NOT INSERTED");
            }
        } catch (Exception e) {
            System.err.println("Got an exception!");
            e.printStackTrace();
        }

    }
    public void dbConfig(){
        initJDBC();
        createDB();
        createTable();
    }

    }


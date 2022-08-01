package helpers;

import java.sql.*;

public class InitSQLServer {
    //these are variables i declare in the beginning of my code
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost";
    private Connection connection = null;
    public static Statement statement = null;

    public void initSQLServer() {
        try {
            Class.forName(DRIVER).newInstance();
            try {
                connection = DriverManager.getConnection(DATABASE_URL, "root", "tesvan123###");
                statement = connection.createStatement();

                // SQL command to create a database in MySQL.
                String sql = "CREATE DATABASE IF NOT EXISTS DEMODB";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {

                    stmt.execute();
                }
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());



            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

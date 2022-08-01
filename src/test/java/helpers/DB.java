package helpers;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static java.sql.DriverManager.*;

public class DB {

   // public static final String DRIVER = "com.mysql.jdbc.Driver";

        public static void create(){

                // Defines the JDBC URL. As you can see, we are not specifying
                // the database name in the URL.
                String url = "jdbc:mysql://localhost:3306";

                // Defines username and password to connect to database server.
                String username = "root";
                String password = "tesvan123###";

                // SQL command to create a database in MySQL.
                String sql = "CREATE DATABASE IF NOT EXISTS DEMODB";

            try (Connection conn = getConnection(url, username, password)) {
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                    stmt.execute();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            }
        }



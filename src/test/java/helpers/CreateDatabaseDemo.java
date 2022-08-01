package helpers;
/////////correct connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabaseDemo {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class.forName(DRIVER).newInstance();
        Connection con = null;
        Statement stmt = null;
        String yourDatabaseName = "Rest_Assured_DB";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306",
                    "root", "tesvan123###");
            stmt = con.createStatement();
            int status = stmt.executeUpdate("CREATE DATABASE " + yourDatabaseName);
            if (status > 0) {
                System.out.println("Database is created successfully !!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

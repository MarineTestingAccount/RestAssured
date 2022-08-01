package helpers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

public class ConnectToDB {
    static final String DB_URL = "https://localhost:3306";
    static final String USER = "root";
    static final String PASS = "tesvan123###";

    public void connectToDB() throws SQLException, IOException {
        URL obj = new URL(DB_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    }


}



package phon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private String hostName = "localhost:3306";
    private String dbName = "DIENTHOAI";
    private String username = "root";
    private String password = "2004";

    private String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;

    public Connection connect() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Kết nối thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void main(String[] args) {
        Connect connect = new Connect();
        connect.connect();
    }
}
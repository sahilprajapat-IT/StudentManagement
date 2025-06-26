package org.s;
import com.mysql.cj.util.DnsSrv;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class DatabaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/studentdb";
    private static  String user = "root";
    private static String password = "admin";
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

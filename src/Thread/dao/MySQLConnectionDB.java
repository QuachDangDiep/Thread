package Thread.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionDB {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EmployeeFPT1";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    // Phương thức để thiết lập kết nối đến cơ sở dữ liệu MySQL
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Đăng ký JDBC driver
            Class.forName(JDBC_DRIVER);

            // Thiết lập kết nối
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Phương thức để đóng kết nối
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


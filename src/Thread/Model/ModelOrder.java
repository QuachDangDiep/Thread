package Thread.Model;

import Thread.Entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelOrder {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EmployeeFPT1";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public void addOrder(Order order) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO orders (orders_id, customer_id, product_id, orders_date) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, order.getId());
            stmt.setInt(2, order.getCustomerId());
            stmt.setInt(3, order.getProductId());
            stmt.setDate(4, new java.sql.Date(order.getOrdersDate().getTime()));

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql = "SELECT * FROM orders";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("orders_id");
                int customerId = rs.getInt("customer_id");
                int productId = rs.getInt("product_id");
                java.sql.Date sqlDate = rs.getDate("orders_date"); // Lấy ngày tháng từ ResultSet
                java.util.Date ordersDate = new java.util.Date(sqlDate.getTime()); // Chuyển đổi sang java.util.Date

                orders.add(new Order(id, customerId, productId, ordersDate));
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return orders;
    }

    public void updateOrder(Order order) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "UPDATE orders SET customer_id=?, product_id=?, orders_date=? WHERE orders_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, order.getCustomerId());
            stmt.setInt(2, order.getProductId());
            stmt.setDate(3, new java.sql.Date(order.getOrdersDate().getTime())); // Sử dụng phương thức getTime() mà không có đối số
            stmt.setInt(4, order.getId());

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    public void deleteOrder(int orderId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "DELETE FROM orders WHERE orders_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderId);

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

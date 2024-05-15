package Thread.Model;

import Thread.Entity.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelOrderDetail {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EmployeeFPT1";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public void addOrderDetail(OrderDetail orderDetail) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO orderdetail (ordersdetail_id, customer_id, product_id, orders_id) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderDetail.getId());
            stmt.setInt(2, orderDetail.getCustomerId());
            stmt.setInt(3, orderDetail.getProductId());
            stmt.setInt(4, orderDetail.getOrderId());

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

    public List<OrderDetail> getAllOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql = "SELECT * FROM orderdetail";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ordersdetail_id");
                int customerId = rs.getInt("customer_id");
                int productId = rs.getInt("product_id");
                int orderId = rs.getInt("orders_id");
                double price = rs.getDouble("price");
                orderDetails.add(new OrderDetail(id, customerId, productId, orderId));
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
        return orderDetails;
    }
    public void deleteOrderDetail(int orderDetailId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "DELETE FROM orderdetail WHERE ordersdetail_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderDetailId);

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
    public void updateOrderDetail(OrderDetail orderDetail) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "UPDATE orderdetail SET customer_id=?, product_id=?, orders_id=? WHERE ordersdetail_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orderDetail.getCustomerId());
            stmt.setInt(2, orderDetail.getProductId());
            stmt.setInt(3, orderDetail.getOrderId());
            stmt.setInt(4, orderDetail.getId());

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


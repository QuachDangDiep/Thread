package Thread.Model;

import Thread.Entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelProduct {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EmployeeFPT1";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public void addProduct(Product product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO product (product_id, product_name, product_description, product_price) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setDouble(4, product.getPrice());

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

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();
            String sql = "SELECT * FROM product";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("product_id");
                String name = rs.getString("product_name");
                String description = rs.getString("product_description");
                double price = rs.getDouble("product_price");
                products.add(new Product(id, name, description, price));
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
        return products;
    }
    public void updateProduct(Product product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // Đăng ký JDBC driver và mở kết nối
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Chuẩn bị câu lệnh SQL để cập nhật thông tin của sản phẩm
            String sql = "UPDATE product SET product_name=?, product_description=?, product_price=? WHERE product_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getId());

            // Thực thi câu lệnh SQL để cập nhật thông tin của sản phẩm
            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và tài nguyên liên quan
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void deleteProduct(int productId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "DELETE FROM product WHERE product_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, productId);

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


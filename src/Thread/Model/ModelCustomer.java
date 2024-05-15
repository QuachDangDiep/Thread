package Thread.Model;

import Thread.Entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelCustomer {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EmployeeFPT1";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public void addCustomer(Customer customer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "INSERT INTO customer (customer_id, customer_name, customer_address, customer_phone, customer_email) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customer.getId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getPhone());
            stmt.setString(5, customer.getEmail());

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM customer";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String name = rs.getString("customer_name");
                String address = rs.getString("customer_address");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                customers.add(new Customer(id, name, address, phone, email));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        return customers;
    }

    public void updateCustomer(Customer customer) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "UPDATE customer SET customer_name=?, customer_address=?, customer_phone=?, customer_email=? WHERE customer_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getAddress());
            stmt.setString(3, customer.getPhone());
            stmt.setString(4, customer.getEmail());
            stmt.setInt(5, customer.getId());

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    public void deleteCustomer(int customerId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String sql = "DELETE FROM customer WHERE customer_id=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customerId);

            stmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, null);
        }
    }

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}

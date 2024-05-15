package Thread;

import Thread.Controller.Controller;
import Thread.Entity.Customer;
import Thread.Entity.Order;
import Thread.Entity.OrderDetail;
import Thread.Entity.Product;
import Thread.Model.Model;
import Thread.Model.ModelCustomer;
import Thread.Model.ModelOrder;
import Thread.Model.ModelOrderDetail;
import Thread.Model.ModelProduct;
import Thread.ui.ConsoleUI;

import java.sql.SQLException;

public class RunApplication {
    public static void main(String[] args) throws SQLException {
        // Khởi tạo các model và controller cho các đối tượng
        Model<Customer> customerModel = new Model<>();
        Model<Product> productModel = new Model<>();
        Model<Order> orderModel = new Model<>();
        Model<OrderDetail> orderDetailModel = new Model<>();

        Controller<Customer> customerController = new Controller<>(customerModel);
        Controller<Product> productController = new Controller<>(productModel);
        Controller<Order> orderController = new Controller<>(orderModel);
        Controller<OrderDetail> orderDetailController = new Controller<>(orderDetailModel);

        // Khởi tạo giao diện người dùng
        ConsoleUI consoleUI = new ConsoleUI(customerController, productController, orderController, orderDetailController);

        // Chạy ứng dụng
        consoleUI.start();
    }
}


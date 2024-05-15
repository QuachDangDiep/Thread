package Thread.ui;

import Thread.Controller.*;
import Thread.Entity.Customer;
import Thread.Entity.Order;
import Thread.Entity.OrderDetail;
import Thread.Entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private CustomerController customerController;
    private ProductController productController;
    private OrderController orderController;
    private OrderDetailController orderDetailController;

    public ConsoleUI(CustomerController customerController, ProductController productController, OrderController orderController, OrderDetailController orderDetailController) {
        this.customerController = customerController;
        this.productController = productController;
        this.orderController = orderController;
        this.orderDetailController = orderDetailController;
    }

    public ConsoleUI(Controller<Customer> customerController, Controller<Product> productController, Controller<Order> orderController, Controller<OrderDetail> orderDetailController) {
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1. Manage Customers");
            System.out.println("2. Manage Products");
            System.out.println("3. Manage Orders");
            System.out.println("4. Manage Order Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageCustomers(scanner);
                    break;
                case 2:
                    manageProducts(scanner);
                    break;
                case 3:
                    manageOrders(scanner);
                    break;
                case 4:
                    manageOrderDetails(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void manageCustomers(Scanner scanner) {
        boolean customerMenu = true;
        while (customerMenu) {
            System.out.println("\nCustomer Management:");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    viewAllCustomers();
                    break;
                case 3:
                    updateCustomer(scanner);
                    break;
                case 4:
                    deleteCustomer(scanner);
                    break;
                case 5:
                    customerMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addCustomer(Scanner scanner) {
        System.out.println("\nEnter Customer Details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Customer newCustomer = new Customer(id, name, address, phone, email);
        customerController.addEntityController(newCustomer);
        System.out.println("Customer added successfully.");
    }

    private void viewAllCustomers() {
        List<Customer> customers = customerController.getAllEntityController();
        System.out.println("\nAll Customers:");
        for (Customer customer : customers) {
            System.out.println("ID: " + customer.getId() + ", Name: " + customer.getCustomername() +
                    ", Address: " + customer.getCustomeraddress() + ", Phone: " + customer.getCustomerphone() +
                    ", Email: " + customer.getCustomeremail());
        }
    }

    private void updateCustomer(Scanner scanner) {
        viewAllCustomers();
        System.out.print("\nEnter ID of the customer to update: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        Customer existingCustomer = customerController.getEntityByIdController(customerId);
        if (existingCustomer != null) {
            System.out.println("\nEnter new details for Customer with ID " + customerId + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            existingCustomer.setCustomername(name);
            existingCustomer.setCustomeraddress(address);
            existingCustomer.setCustomerphone(phone);
            existingCustomer.setCustomeremail(email);

            customerController.updateEntityController(existingCustomer);
            System.out.println("Customer with ID " + customerId + " updated successfully.");
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }

    private void deleteCustomer(Scanner scanner) {
        viewAllCustomers(); // Hiển thị danh sách khách hàng trước khi xóa
        System.out.print("\nEnter ID of the customer to delete: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        customerController.deleteEntityController(customerId);
        System.out.println("Customer with ID " + customerId + " deleted successfully.");
    }


    private void manageProducts(Scanner scanner) {
        boolean productMenu = true;
        while (productMenu) {
            System.out.println("\nProduct Management:");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    updateProduct(scanner);
                    break;
                case 4:
                    deleteProduct(scanner);
                    break;
                case 5:
                    productMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProduct(Scanner scanner) {
        System.out.println("\nEnter Product Details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Product newProduct = new Product(id, name, description, price);
        productController.addEntityController(newProduct);
        System.out.println("Product added successfully.");
    }

    private void viewAllProducts() {
        List<Product> products = productController.getAllEntityController();
        System.out.println("\nAll Products:");
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() +
                    ", Description: " + product.getDesciption() + ", Price: $" + product.getPrice());
        }
    }

    private void updateProduct(Scanner scanner) {
        viewAllProducts(); // Hiển thị danh sách sản phẩm trước khi cập nhật
        System.out.print("\nEnter ID of the product to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        Product existingProduct = productController.getEntityByIdController(productId);
        if (existingProduct != null) {
            System.out.println("\nEnter new details for Product with ID " + productId + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Description: ");
            String description = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();

            existingProduct.setName(name);
            existingProduct.setDesciption(description);
            existingProduct.setPrice(price);

            productController.updateEntityController(existingProduct);
            System.out.println("Product with ID " + productId + " updated successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    private void deleteProduct(Scanner scanner) {
        viewAllProducts(); // Hiển thị danh sách sản phẩm trước khi xóa
        System.out.print("\nEnter ID of the product to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        productController.deleteEntityController(productId);
        System.out.println("Product with ID " + productId + " deleted successfully.");
    }


    private void manageOrders(Scanner scanner) {
        boolean orderMenu = true;
        while (orderMenu) {
            System.out.println("\nOrder Management:");
            System.out.println("1. Add Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addOrder(scanner);
                    break;
                case 2:
                    viewAllOrders();
                    break;
                case 3:
                    updateOrder(scanner);
                    break;
                case 4:
                    deleteOrder(scanner);
                    break;
                case 5:
                    orderMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addOrder(Scanner scanner) {
        System.out.println("\nEnter Order Details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Order Date (YYYY-MM-DD): ");
        String orderDateStr = scanner.nextLine();
        java.util.Date orderDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            orderDate = dateFormat.parse(orderDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
            return;
        }

        Order newOrder = new Order(id, customerId, productId, orderDate);
        orderController.addEntityController(newOrder);
        System.out.println("Order added successfully.");
    }

    private void viewAllOrders() {
        List<Order> orders = orderController.getAllEntityController();
        System.out.println("\nAll Orders:");
        for (Order order : orders) {
            System.out.println("ID: " + order.getId() + ", Customer ID: " + order.getCustomerId() +
                    ", Product ID: " + order.getProductId() + ", Order Date: " + order.getOrdersDate());
        }
    }

    private void updateOrder(Scanner scanner) {
        viewAllOrders();
        System.out.print("\nEnter ID of the order to update: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        Order existingOrder = orderController.getEntityByIdController(orderId);
        if (existingOrder != null) {
            System.out.println("\nEnter new details for Order with ID " + orderId + ":");
            System.out.print("Customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            System.out.print("Product ID: ");
            int productId = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            System.out.print("Order Date (YYYY-MM-DD): ");
            String orderDateStr = scanner.nextLine();
            java.util.Date orderDate = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                orderDate = dateFormat.parse(orderDateStr);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("Invalid date format. Please enter date in YYYY-MM-DD format.");
                return;
            }

            existingOrder.setCustomerId(customerId);
            existingOrder.setProductId(productId);
            existingOrder.setOrdersDate(orderDate);

            orderController.updateEntityController(existingOrder);
            System.out.println("Order with ID " + orderId + " updated successfully.");
        } else {
            System.out.println("Order with ID " + orderId + " not found.");
        }
    }

    private void deleteOrder(Scanner scanner) {
        viewAllOrders();
        System.out.print("\nEnter ID of the order to delete: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        orderController.deleteEntityController(orderId);
        System.out.println("Order with ID " + orderId + " deleted successfully.");
    }

    private void manageOrderDetails(Scanner scanner) {
        boolean orderDetailMenu = true;
        while (orderDetailMenu) {
            System.out.println("\nOrder Detail Management:");
            System.out.println("1. Add Order Detail");
            System.out.println("2. View All Order Details");
            System.out.println("3. Delete Order Detail");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    addOrderDetail(scanner);
                    break;
                case 2:
                    viewAllOrderDetails();
                    break;
                case 3:
                    deleteOrderDetail(scanner);
                    break;
                case 4:
                    orderDetailMenu = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addOrderDetail(Scanner scanner) {
        System.out.println("\nEnter Order Detail:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        OrderDetail newOrderDetail = new OrderDetail(id, customerId, productId, orderId);
        orderDetailController.addEntityController(newOrderDetail);
        System.out.println("Order Detail added successfully.");
    }

    private void viewAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailController.getAllEntityController();
        System.out.println("\nAll Order Details:");
        for (OrderDetail orderDetail : orderDetails) {
            System.out.println("ID: " + orderDetail.getId() + ", Customer ID: " + orderDetail.getCustomerId() +
                    ", Product ID: " + orderDetail.getProductId() + ", Order ID: " + orderDetail.getOrderId());
        }
    }

    private void deleteOrderDetail(Scanner scanner) {
        viewAllOrderDetails(); // Hiển thị danh sách chi tiết đơn hàng trước khi xóa
        System.out.print("\nEnter ID of the order detail to delete: ");
        int orderDetailId = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        orderDetailController.deleteEntityController(orderDetailId);
        System.out.println("Order Detail with ID " + orderDetailId + " deleted successfully.");
    }

}

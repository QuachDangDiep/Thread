package Thread.Controller;

import Thread.Entity.Order;
import Thread.Model.ModelOrder;

import java.util.List;

public class OrderController {
    private ModelOrder model;

    public OrderController(ModelOrder model) {
        this.model = model;
    }

    public void addOrder(int orderId, int customerId, int productId, java.util.Date ordersDate) {
        Order order = new Order(orderId, customerId, productId, ordersDate);
        model.addOrder(order);
    }

    public List<Order> getAllOrders() {
        return model.getAllOrders();
    }

    public void updateOrder(int orderId, int customerId, int productId, java.util.Date ordersDate) {
        Order order = new Order(orderId, customerId, productId, ordersDate);
        model.updateOrder(order);
    }

    public void deleteOrder(int orderId) {
        model.deleteOrder(orderId);
    }

    public void addEntityController(Order newOrder) {
    }

    public List<Order> getAllEntityController() {
        return null;
    }

    public Order getEntityByIdController(int orderId) {
        return null;
    }

    public void updateEntityController(Order existingOrder) {
    }

    public void deleteEntityController(int orderId) {

    }
}

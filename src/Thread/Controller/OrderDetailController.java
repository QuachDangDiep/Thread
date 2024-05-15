package Thread.Controller;

import Thread.Entity.OrderDetail;
import Thread.Model.ModelOrderDetail;

import java.util.List;

public class OrderDetailController {
    private ModelOrderDetail model;

    public OrderDetailController(ModelOrderDetail model) {
        this.model = model;
    }

    public void addOrderDetail(int orderDetailId, int orderId, int productId, int quantity, double Price) {
        OrderDetail orderDetail = new OrderDetail(orderDetailId, orderId, productId, quantity);
        model.addOrderDetail(orderDetail);
    }

    public List<OrderDetail> getAllOrderDetails() {
        return model.getAllOrderDetails();
    }

    public void updateOrderDetail(int orderDetailId, int orderId, int productId, int quantity, double Price) {
        OrderDetail orderDetail = new OrderDetail(orderDetailId, orderId, productId, quantity);
        model.updateOrderDetail(orderDetail);
    }

    public void deleteOrderDetail(int orderDetailId) {
        model.deleteOrderDetail(orderDetailId);
    }

    public void addEntityController(OrderDetail newOrderDetail) {
    }

    public List<OrderDetail> getAllEntityController() {
        return null;
    }

    public void deleteEntityController(int orderDetailId) {

    }
}


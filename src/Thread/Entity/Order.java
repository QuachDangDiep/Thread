package Thread.Entity;

import java.sql.CallableStatement;
import java.util.Date;
import java.util.List;

public class Order extends Entity<Integer>{
    private int customerId;
    private Date createAt;
    private String paymentType;
    private List<OrderDetail> orderDetails;

    public Order(Integer id, int customerId, int productId, Date ordersDate) {
        super(id);
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getProductId() {
        return getProductId();
    }

    public CallableStatement getOrdersDate() {
        return getOrdersDate();
    }

    public void setProductId(int productId) {
    }

    public void setOrdersDate(Date orderDate) {

    }
}

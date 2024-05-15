package Thread.Model;

import Thread.Entity.*;

import java.util.ArrayList;
import java.util.List;

public class Model <T extends Entity<?>> {
    private List<T> entities = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<OrderDetail> orderDetails =new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public void addEntity(T entity){
        entities.add(entity);
    }
    public List<T> getAllEntities(){
        return entities;
    }
    public List<Product> getAllProducts() {
        return products;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetails;
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
    public void updateEntity(T entity) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId().equals(entity.getId())) {
                entities.set(i, entity);
                break;
            }
        }
    }
    public void deleteEntity(T entity) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId().equals(entity.getId())) {
                entities.remove(i);
                break;
            }
        }
    }
}




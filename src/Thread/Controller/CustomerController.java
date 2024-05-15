package Thread.Controller;

import Thread.Entity.Customer;
import Thread.Model.ModelCustomer;

import java.util.List;

public class CustomerController {
    private ModelCustomer model;

    public CustomerController(ModelCustomer model) {
        this.model = model;
    }

    public void addCustomer(int id, String name, String address, String phone, String email) {
        Customer customer = new Customer(id, name, address, phone, email);
        model.addCustomer(customer);
    }

    public List<Customer> getAllCustomers() {
        return model.getAllCustomers();
    }

    public void updateCustomer(int id, String name, String address, String phone, String email) {
        Customer customer = new Customer(id, name, address, phone, email);
        model.updateCustomer(customer);
    }

    public void deleteCustomer(int customerId) {
        model.deleteCustomer(customerId);
    }

    public List<Customer> getAllEntityController() {
        return List.of();
    }

    public Customer getEntityByIdController(int customerId) {
        return null;
    }

    public void updateEntityController(Customer existingCustomer) {
    }

    public void deleteEntityController(int customerId) {
    }

    public void addEntityController(Customer newCustomer) {

    }
}


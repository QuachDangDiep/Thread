package Thread.Controller;

import Thread.Entity.Product;
import Thread.Model.ModelProduct;

import java.util.List;

public class ProductController {
    private ModelProduct model;

    public ProductController(ModelProduct model) {
        this.model = model;
    }

    public void addProduct(int id, String name, String description, double price) {
        Product product = new Product(id, name, description, price);
        model.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return model.getAllProducts();
    }

    public void updateProduct(int id, String name, String description, double price) {
        Product product = new Product(id, name, description, price);
        model.updateProduct(product);
    }

    public void deleteProduct(int productId) {
        model.deleteProduct(productId);
    }

    public void addEntityController(Product newProduct) {
    }

    public List<Product> getAllEntityController() {
        return null;
    }

    public Product getEntityByIdController(int productId) {
        return null;
    }

    public void updateEntityController(Product existingProduct) {
    }

    public void deleteEntityController(int productId) {

    }
}


package Thread.Entity;

public class Product extends Entity<Integer> {
    private String name;
    private String description;
    private double price;

    public Product(Integer id, String name, String description, double price) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesciption() {
        return description;
    }

    public void setDesciption(String description) {

    }
}

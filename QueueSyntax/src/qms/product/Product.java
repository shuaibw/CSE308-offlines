package qms.product;

public abstract class Product {
    protected double price;
    protected String description;
    protected String type;

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }
}

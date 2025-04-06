package vn.tayjava.dto.request;

public class ProductRequestDTO {
    private String name;
    private String category;
    private double price;
    private String description;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name, String category, double price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

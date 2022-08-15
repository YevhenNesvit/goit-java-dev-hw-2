import java.util.Objects;

class Product {
    private String productName;
    private double productPrice;
    private int discountedQuantity;
    private double discountedPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Product(String productName, double productPrice, int discountedQuantity, double discountedPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.discountedQuantity = discountedQuantity;
        this.discountedPrice = discountedPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getDiscountedQuantity() {
        return discountedQuantity;
    }

    public double getDiscountedPrice() {
        return discountedPrice;
    }

    @Override
    public String toString() {
        return "Product {" +
                "productName = '" + productName + '\'' +
                ", productPrice = " + productPrice +
                ", discountedQuantity = " + discountedQuantity +
                ", discountedPrice = " + discountedPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getProductPrice(), getProductPrice()) == 0 && getDiscountedQuantity()
                == product.getDiscountedQuantity() && Double.compare(product.getDiscountedPrice(), getDiscountedPrice())
                == 0 && Objects.equals(getProductName(), product.getProductName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductName(), getProductPrice(), getDiscountedQuantity(), getDiscountedPrice());
    }
}
class ProductsBase {
    private Product productA = new Product("A",1.25, 3,3.00);
    private Product productB= new Product("B",4.25);
    private Product productC = new Product("C",1.00, 6,5.00);
    private Product productD = new Product("D",0.75);

    public Product getProductA() {
        return productA;
    }

    public Product getProductB() {
        return productB;
    }

    public Product getProductC() {
        return productC;
    }

    public Product getProductD() {
        return productD;
    }
}
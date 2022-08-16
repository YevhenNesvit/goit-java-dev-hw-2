import java.util.HashMap;
import java.util.Map;

class TotalCalculator {
    ProductsBase productsBase = new ProductsBase();

    public HashMap<String, Product> repository = new HashMap<>();

    public HashMap<String, Integer> getQuantityPerProduct(String names) {
        String[] list;
        try {
            list = names.split("");
        } catch (NullPointerException npe) {
            throw new NullPointerException("Basket contains null");
        }
        HashMap<String, Integer> productsCount = new HashMap<>();

        for (String l : list) {
            productsCount.put(l, !productsCount.containsKey(l) ? 1 : productsCount.get(l) + 1);
        }
        System.out.println(productsCount);
        return productsCount;
    }

    public HashMap<String, Product> repositoryFilling() {
        repository.put("A", productsBase.getProductA());
        repository.put("B", productsBase.getProductB());
        repository.put("C", productsBase.getProductC());
        repository.put("D", productsBase.getProductD());

        return repository;
    }

    public double getSum(String shoppingCart) {
        HashMap<String, Integer> productsQuantity = getQuantityPerProduct(shoppingCart);
        double simpleSum = 0;
        double discountedSum = 0;

        for (Map.Entry<String, Integer> item : productsQuantity.entrySet()) {
            if (repositoryFilling().containsKey(item.getKey())) {
                if (repositoryFilling().get(item.getKey()).getDiscountedQuantity() != 0) {
                    if (item.getValue() == repositoryFilling().get(item.getKey()).getDiscountedQuantity()) {
                        discountedSum += repositoryFilling().get(item.getKey()).getDiscountedPrice();
                    } else if (item.getValue() > repositoryFilling().get(item.getKey()).getDiscountedQuantity()) {
                        discountedSum += (int) ((item.getValue() / repositoryFilling().get(item.getKey()).getDiscountedQuantity())
                                * repositoryFilling().get(item.getKey()).getDiscountedPrice())
                                + ((item.getValue() % repositoryFilling().get(item.getKey()).getDiscountedQuantity())
                                * repositoryFilling().get(item.getKey()).getProductPrice());
                    } else {
                        simpleSum += item.getValue() * repositoryFilling().get(item.getKey()).getProductPrice();
                    }
                } else {
                    simpleSum += item.getValue() * repositoryFilling().get(item.getKey()).getProductPrice();
                }
            }
        }

        return simpleSum + discountedSum;
    }
}
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TotalCalculator {
    ProductsBase productsBase = new ProductsBase();
    public List<Product> repository = List.of(productsBase.getProductA(), productsBase.getProductB(),
            productsBase.getProductC(), productsBase.getProductD());

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

        return productsCount;
    }

    public double getSum(String shoppingCart) {
        HashMap<String, Integer> productsQuantity = getQuantityPerProduct(shoppingCart);
        double simpleSum = 0;
        double discountedSum = 0;
        int count = 0;

        for (Map.Entry<String, Integer> item : productsQuantity.entrySet()) {
            if (!item.getKey().equals(repository.get(count).getProductName())) {
                count++;
            }
            if (repository.get(count).getDiscountedQuantity() != 0) {
                if (item.getValue() >= repository.get(count).getDiscountedQuantity()) {
                    discountedSum += item.getValue() * (repository.get(count).getDiscountedPrice() / repository.get(count).getDiscountedQuantity());
                } else {
                    simpleSum += item.getValue() * repository.get(count).getProductPrice();
                }
            } else {
                simpleSum += item.getValue() * repository.get(count).getProductPrice();
            }
            count++;
        }

        return simpleSum + discountedSum;
    }
}
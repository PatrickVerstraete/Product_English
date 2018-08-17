package be.oak3.persistence;

import be.oak3.model.Parfum;
import be.oak3.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderImpl implements Order {
    public static final Logger LOGGER = LogManager.getLogger();

    // INSTANCE VARIABELEN
    private List<Product> products;
    private static int productNumber = 1000;

    // CONSTRUCTORS
    public OrderImpl() {
        products = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        product.setProductNumber(productNumber++);
        products.add(product);
    }

    @Override
    public void sortOnBrandName() {
        products.stream().sorted(Product.sortOnBrandName()).forEach(LOGGER::debug);
}

    @Override
    public void showProductsOfBrandName(String brandName) {
        products.stream().filter(product -> product.getBrandName().equalsIgnoreCase(brandName)).forEach(LOGGER::debug);
    }

    @Override
    public void showOnlyParfums() {
        products.stream().filter(product -> product instanceof Parfum).forEach(LOGGER::debug);
    }

    @Override
    public Product searchMostExpensiveProduct() {
        return products.stream().max(Comparator.comparingDouble(Product::getPrice)).get();
    }

    @Override
    public void sort() {
    //    products.stream().sorted().forEach(System.out::println);
        products.stream().sorted().forEach(product -> LOGGER.debug(product));
    }

    @Override
    public void sortOnVolume() {
        products.stream().sorted(Comparator.comparingInt(Product::getVolume)).forEach(LOGGER::debug);
    }

    @Override
    public void showAllProductsWithPriceLowerThen50() {
        products.stream().filter(product -> product.getPrice() < 50).forEach(LOGGER::debug);
    }

    @Override
    public double totalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}

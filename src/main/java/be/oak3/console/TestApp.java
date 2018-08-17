package be.oak3.console;

import be.oak3.model.Product;
import be.oak3.persistence.Data;
import be.oak3.persistence.Order;
import be.oak3.persistence.OrderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TestApp {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        String txt = String.format("Solution of %s %s\n", "Kenneth Van Gijsel ",
                "Java Trainer");

        LOGGER.debug(txt);
//        System.out.printf("Solution of %s %s\n", "Kenneth Van Gijsel ",
//                "Java Trainer");

        Order order = new OrderImpl();
        List<Product> lijst = Data.getData();

        for (Product artikel : lijst) {
            order.addProduct(artikel);
        }

        LOGGER.debug("List sorted on NATURAL ORDER: ");
//        System.out.println("List sorted on NATURAL ORDER: ");
        order.sort();

        txt = String.format("List sorted on brandName: ");
        LOGGER.debug(txt);
//        System.out.println("\nList sorted on brandName: ");
        order.sortOnBrandName();

        txt = String.format("List sorted on volume: ");
        LOGGER.debug(txt);
//        System.out.println("\nList sorted on volume: ");
        order.sortOnVolume();

        txt = String.format("All products of brandname Georgio Armani");
        LOGGER.debug(txt);
//        System.out.println("\nAll products of brandname Georgio Armani");
        order.showProductsOfBrandName("Georgio Armani");

        txt = String.format("All Parfums:");
        LOGGER.debug(txt);
//        System.out.println("\nAll Parfums:");
        order.showOnlyParfums();

        txt = String.format("All products lower then €50: ");
        LOGGER.debug(txt);
//        System.out.println("\nAll products lower then €50; ");
        order.showAllProductsWithPriceLowerThen50();

        Product product = order.searchMostExpensiveProduct();
        txt = String.format("Most expensive product:" + product);
        LOGGER.debug(txt);
//        System.out.println("\nMost expensive product:\n" + product);

        txt = String.format("Total price of all products: €%.2f", order.totalPrice());;
        LOGGER.debug(txt);
//        System.out.printf("\nTotal price of all products: €%.2f", order.totalPrice());

    }
}

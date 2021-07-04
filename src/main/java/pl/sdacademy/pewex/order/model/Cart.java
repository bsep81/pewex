package pl.sdacademy.pewex.order.model;

import pl.sdacademy.pewex.product.model.Product;

import java.util.HashMap;


public class Cart {

    HashMap<Product, Integer> cart = new HashMap<Product, Integer>() {
    };

    public void addProduct(Product product) {
        if (cart.containsKey(product)) {
            cart.put(product,cart.get(product)+1);
        } else {
            cart.put(product,1);
        }
    }

    public void removeProduct(Product product) {
        if (cart.containsKey(product) && cart.get(product) > 1) {
            cart.put(product,cart.get(product)-1);
        } else {
            cart.remove(product);
        }
    }


}

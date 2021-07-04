package pl.sdacademy.pewex.order.model;

import org.springframework.stereotype.Service;
import pl.sdacademy.pewex.product.model.Product;

import java.util.HashMap;

@Service
public class CartService {

    HashMap<Product, Integer> cart = new HashMap<Product, Integer>() {
    };

    public String getProductsInCart() {
        return cart.entrySet().toString();
    }
}

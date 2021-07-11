package pl.sdacademy.pewex.order.service;

import org.springframework.stereotype.Service;
import pl.sdacademy.pewex.product.model.Product;

import java.util.HashMap;


@Service
public class CartService {

    HashMap<Product, Integer> cart = new HashMap<>() {
    };

    public String getProductsInCart() {
        return cart.entrySet().toString();
    }
}
package pl.sdacademy.pewex.order.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


public class Cart {

    // String - hash zapisany jako cookie
    private Map<String, Set<OrderedProduct>> productPerSession = new HashMap<>();

    public List<OrderedProduct> addProduct(String orderId, long productId, int add) {
        productPerSession.putIfAbsent(orderId, new HashSet<>());

        productPerSession.computeIfPresent(orderId, (orderId1, currentState) -> {
            addNewProductOrUpdatePreviouslyAdded(productId, add, currentState);
            return currentState;
        });

        return currentState(orderId);
    }

    private void addNewProductOrUpdatePreviouslyAdded(long productId, int added, Set<OrderedProduct> currentState) {
        Optional<OrderedProduct> exist = currentState.stream()
                .filter(orderedProduct -> orderedProduct.getId() == productId)
                .findAny();
        exist.ifPresentOrElse(
                orderedProduct -> orderedProduct.setHowMany(orderedProduct.getHowMany() + added),
                () ->
                        currentState.add(OrderedProduct.builder()
                                .id(productId)
                                .howMany(added)
                                .build()));
    }

    public List<OrderedProduct> currentState(String orderId) {
        return new ArrayList<>(productPerSession.getOrDefault(orderId, Collections.emptySet()));
    }

//    public void removeProduct(Product product) {
//        if (cart.containsKey(product) && cart.get(product) > 1) {
//            cart.put(product,cart.get(product)-1);
//        } else {
//            cart.remove(product);
//        }
//    }


}

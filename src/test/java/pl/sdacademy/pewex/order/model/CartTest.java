package pl.sdacademy.pewex.order.model;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    private Cart sut = new Cart();

    @Test
    void shouldAddFirstProductToCart() {
        long orderId = 100L;
        int howMany = 10;
        OrderedProduct addedProduct = OrderedProduct.builder()
                .id(orderId)
                .howMany(howMany)
                .build();
        String myId = UUID.randomUUID().toString();

        List<OrderedProduct> result = sut.addProduct(myId, orderId, howMany);

        assertThat(result)
                .hasSize(1)
                .contains(addedProduct);
    }

    @Test
    void shouldReturnEmptyListIfNothingOrdered() {
        String myId = UUID.randomUUID().toString();

        List<OrderedProduct> result = sut.currentState(myId);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldLetOrderMoreThan1Product() {
        long orderId1 = 100L;
        int howMany1 = 10;
        long orderId2 = 200L;
        int howMany2 = 5;
        OrderedProduct addedProduct1 = OrderedProduct.builder()
                .id(orderId1)
                .howMany(howMany1)
                .build();
        OrderedProduct addedProduct2 = OrderedProduct.builder()
                .id(orderId2)
                .howMany(howMany2)
                .build();
        String myId = UUID.randomUUID().toString();

        sut.addProduct(myId, orderId1, howMany1);
        List<OrderedProduct> result = sut.addProduct(myId, orderId2, howMany2);

        assertThat(result)
                .hasSize(2)
                .containsExactly(addedProduct1, addedProduct2);
    }

    @Test
    void shouldLetAddMoreOrderedItem() {
        long orderId1 = 100L;
        int howMany1 = 10;
        long orderId2 = 200L;
        int howMany2 = 5;
        OrderedProduct addedProduct1 = OrderedProduct.builder()
                .id(orderId1)
                .howMany(howMany1)
                .build();
        OrderedProduct addedProduct2 = OrderedProduct.builder()
                .id(orderId2)
                .howMany(howMany2)
                .build();
        String myId = UUID.randomUUID().toString();

        sut.addProduct(myId, orderId1, 8);
        sut.addProduct(myId, orderId1, 2);
        List<OrderedProduct> result = sut.addProduct(myId, orderId2, howMany2);

        assertThat(result)
                .hasSize(2);
        assertThat(result.stream()
                .mapToInt(OrderedProduct::getHowMany)
                .sum())
                .isEqualTo(15);

    }
}

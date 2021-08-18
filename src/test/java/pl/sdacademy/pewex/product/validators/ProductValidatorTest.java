package pl.sdacademy.pewex.product.validators;

import org.junit.jupiter.api.Test;
import pl.sdacademy.pewex.product.model.Product;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductValidatorTest {

    private final ProductValidator sut = new ProductValidator();

    @Test
    void shouldReturnEmptyListIfProductIsValid(){

        Product product = Product.builder()
                .id(1L)
                .title("Test title")
                .author("Test Author")
                .price(new BigDecimal("99.99"))
                .description("Test description")
                .rating(new BigDecimal("4.5"))
                .build();

        List<String> result = sut.isValid(product);

        assertThat(result)
                .isEmpty();
    }

    @Test
    void shouldReturnListOfErrorsIfProductIsNotValid(){
        Product product = new Product();

        List<String> results = sut.isValid(product);

        assertThat(results)
                .containsExactly("Field 'author' can not be empty", "Field 'title' can not be empty", "Product nedds to hava a price");
    }

}
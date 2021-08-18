package pl.sdacademy.pewex.product.mappers;

import org.junit.jupiter.api.Test;
import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.model.Product;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ProductMapperTest {

    private final ProductMapper sut = new ProductMapper();

    @Test
    void shouldMapEntityToProduct() {

        ProductEntity entity = ProductEntity.builder()
                .id(1L)
                .title("Test title")
                .author("Test Author")
                .price(new BigDecimal("99.99"))
                .description("Test description")
                .rating(new BigDecimal("4.5"))
                .build();

        Product product = Product.builder()
                .id(1L)
                .title("Test title")
                .author("Test Author")
                .price(new BigDecimal("99.99"))
                .description("Test description")
                .rating(new BigDecimal("4.5"))
                .build();

        Optional<Product> result = sut.mapEntityToProduct(entity);

        assertThat(result)
                .isNotEmpty()
                .contains(product);
    }

    @Test
    void shouldReturnEmptyOptionalIfNullEntity(){

        Optional<Product> result = sut.mapEntityToProduct(null);

        assertThat(result).isEmpty();
    }


    @Test
    void shouldMapProductToEntity() {

        ProductEntity entity = ProductEntity.builder()
                .id(1L)
                .title("Test title")
                .author("Test Author")
                .price(new BigDecimal("99.99"))
                .description("Test description")
                .rating(new BigDecimal("4.5"))
                .build();

        Product product = Product.builder()
                .id(1L)
                .title("Test title")
                .author("Test Author")
                .price(new BigDecimal("99.99"))
                .description("Test description")
                .rating(new BigDecimal("4.5"))
                .build();

        ProductEntity result = sut.mapProductToEntity(product);

        assertThat(result)
                .isEqualTo(entity);
    }
}
package pl.sdacademy.pewex.product.mappers;

import org.junit.jupiter.api.Test;
import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.model.ProductDetail;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDetailsMapperTest {

    private ProductDetailsMapper sut = new ProductDetailsMapper();

    @Test
    void shouldMapEntityToProductDetail(){
        ProductEntity entity = ProductEntity.builder()
                .id(1L)
                .title("Test title")
                .price(new BigDecimal("99.99"))
                .description("Test description")
                .rating(new BigDecimal("4.5"))
                .build();

        ProductDetail productDetail = ProductDetail.builder()
                .id(1L)
                .title("Test title")
                .price(new BigDecimal("99.99"))
                .description("Test description")
                .rating(new BigDecimal("4.5"))
                .build();

        Optional<ProductDetail> result = sut.mapEntityToProductDetail(entity);

        assertThat(result)
                .isNotEmpty()
                .contains(productDetail);
    }

    @Test
    void shouldReturnEmptyOptionalIfNullEntity(){

        Optional<ProductDetail> result = sut.mapEntityToProductDetail(null);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldProductDetailToEntity(){

        ProductEntity entity = ProductEntity.builder()
                .title("Test title")
                .price(new BigDecimal("99.99"))
                .description("Test description")
                .rating(new BigDecimal("4.5"))
                .build();

        ProductDetail productDetail = ProductDetail.builder()
                .id(1L)
                .title("Test title")
                .price(new BigDecimal("99.99"))
                .description("Test description")
                .rating(new BigDecimal("4.5"))
                .build();

        ProductEntity result = sut.mapProductDetailToEntity(productDetail);

        assertThat(result)
                .isEqualTo(entity);

    }
}

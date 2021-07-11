package pl.sdacademy.pewex.product.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import pl.sdacademy.pewex.product.model.ProductDetail;
import pl.sdacademy.pewex.product.model.ProductListDTO;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Sql("/integration/product_insert.sql")
class ProductServiceIT {

    @Autowired
    private ProductService productService;


    @Test
    void shouldFetchProductsFromDb() {

        List<ProductListDTO> result = productService.getProductList();

        assertThat(result).hasSize(2);
    }

    @Test
    void shouldGetDetailsOfProduct() {

        ProductDetail result = productService.getProductDetail(1L);

        assertThat(result)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", 1L);
    }
}

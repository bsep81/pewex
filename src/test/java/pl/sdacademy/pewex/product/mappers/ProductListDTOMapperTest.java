package pl.sdacademy.pewex.product.mappers;

import org.junit.jupiter.api.Test;
import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.model.ProductListDTO;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ProductListDTOMapperTest {

    private final ProductListDTOMapper sut = new ProductListDTOMapper();

    @Test
    void shouldMapEntityToProductListDTO(){
        ProductEntity entity = ProductEntity.builder()
                .id(1L)
                .title("Test title")
                .price(new BigDecimal("99.99"))
                .rating(new BigDecimal("4.5"))
                .build();

        ProductListDTO productListDTO = ProductListDTO.builder()
                .id(1L)
                .title("Test title")
                .price(new BigDecimal("99.99"))
                .rating(new BigDecimal("4.5"))
                .build();

        Optional<ProductListDTO> result = sut.mapEntityToProductListDTO(entity);

        assertThat(result)
                .isNotEmpty()
                .contains(productListDTO);

    }

    @Test
    void shouldReturnEmptyOptionalIfNullEntity(){

        Optional<ProductListDTO> result = sut.mapEntityToProductListDTO(null);

        assertThat(result).isEmpty();
    }

    @Test
    void shouldMapProductListDTOToEntity(){

        ProductEntity entity = ProductEntity.builder()
                .title("Test title")
                .price(new BigDecimal("99.99"))
                .rating(new BigDecimal("4.5"))
                .build();

        ProductListDTO productListDTO = ProductListDTO.builder()
                .title("Test title")
                .price(new BigDecimal("99.99"))
                .rating(new BigDecimal("4.5"))
                .build();

        ProductEntity result = sut.mapProductListDTOToEntity(productListDTO);

        assertThat(result)
                .isEqualTo(entity);

    }

}

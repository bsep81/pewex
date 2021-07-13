package pl.sdacademy.pewex.product.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.mappers.ProductListDTOMapper;
import pl.sdacademy.pewex.product.mappers.ProductDetailsMapper;
import pl.sdacademy.pewex.product.model.ProductListDTO;
import pl.sdacademy.pewex.product.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductListDTOMapper productListDTOMapper;
    @Mock
    private ProductDetailsMapper productDetailsMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldGetProductList() {

        // given
        List<ProductListDTO> testList = new ArrayList<>();
        testList.add(new ProductListDTO(1L, "Mistrz i Małgorzata", new BigDecimal("49.99"), new BigDecimal("4.78")));
        testList.add(new ProductListDTO(2L, "Przygody dobrego wojaka Szwejka", new BigDecimal("59.99"), new BigDecimal("4.56")));
        testList.add(new ProductListDTO(3L, "Paragraf 22", new BigDecimal("44.99"), new BigDecimal("4.44")));
        when(productRepository.findAll()).thenReturn(Arrays.asList(
                ProductEntity.builder().id(1L).build(),
                ProductEntity.builder().id(2L).build(),
                ProductEntity.builder().id(3L).build()
        ));
        when(productListDTOMapper.mapEntityToProductListDTO(ProductEntity.builder().id(1L).build())).thenReturn(Optional.of(new ProductListDTO(1L, "Mistrz i Małgorzata", new BigDecimal("49.99"), new BigDecimal("4.78"))));
        when(productListDTOMapper.mapEntityToProductListDTO(ProductEntity.builder().id(2L).build())).thenReturn(Optional.of((new ProductListDTO(2L, "Przygody dobrego wojaka Szwejka", new BigDecimal("59.99"), new BigDecimal("4.56")))));
        when(productListDTOMapper.mapEntityToProductListDTO(ProductEntity.builder().id(3L).build())).thenReturn(Optional.of(new ProductListDTO(3L, "Paragraf 22", new BigDecimal("44.99"), new BigDecimal("4.44"))));

        // when
        List<ProductListDTO> result = productService.getProductList();

        // then
        assertThat(result)
                .hasSize(3)
                .containsAll(testList);

    }

    @Test
    void shouldReturnEmptyListIfNoProductsInDB() {
        // given
        when(productRepository.findAll()).thenReturn(new ArrayList<>());

        // when
        List<ProductListDTO> result = productService.getProductList();

        // then
        assertThat(result).isEmpty();


    }
}

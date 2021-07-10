package pl.sdacademy.pewex.product.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdacademy.pewex.product.mappers.ProductListDTOMapper;
import pl.sdacademy.pewex.product.mappers.ProductMapper;
import pl.sdacademy.pewex.product.model.ProductListDTO;
import pl.sdacademy.pewex.product.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

@Mock
    private  ProductRepository productRepository;
@Mock
    private  ProductListDTOMapper productListDTOMapper;
@Mock
    private  ProductMapper productMapper;

private ProductService productService = new ProductService(productRepository, productListDTOMapper, productMapper );

@Test
    void shouldGetProductList(){

    List<ProductListDTO> testList = new ArrayList<>();
    testList.add(0, new ProductListDTO(1L, "Mistrz i Małgorzata", new BigDecimal(49.99), new BigDecimal(4.78)));
    testList.add(1, new ProductListDTO(2L, "Przygody dobrego wojaka Szwejka", new BigDecimal(59.99), new BigDecimal(4.56)));
    testList.add(2, new ProductListDTO(3L, "Paragraf 22", new BigDecimal(44.99), new BigDecimal(4.44)));


    List<ProductListDTO> products = new ArrayList<>();
    productRepository.findAll().forEach(entity -> products.add(productListDTOMapper.mapEntityToProductListDTO(entity).get()));

    List<ProductListDTO> result = products;

    assertThat(result)
            .isNotEmpty()
            .contains((ProductListDTO) testList);

}

}

package pl.sdacademy.pewex.product.service;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.mappers.ProductListDTOMapper;
import pl.sdacademy.pewex.product.model.ProductDetail;
import pl.sdacademy.pewex.product.model.ProductListDTO;
import pl.sdacademy.pewex.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService implements ProductServiceInterface{

    private final ProductRepository productRepository;
    private final ProductListDTOMapper productListDTOMapper;

    public ProductService(ProductRepository productRepository, ProductListDTOMapper productListDTOMapper) {
        this.productRepository = productRepository;
        this.productListDTOMapper = productListDTOMapper;

    }


    @Override
    public List<ProductListDTO> getProductList() {
        List<ProductListDTO> products = new ArrayList<>();
        productRepository.findAll().forEach(entity -> products.add(productListDTOMapper.mapEntityToProductListDTO(entity).get()));

        return products;
    }

    @Override
    public ProductDetail getProductDetail(Long id) {
        return null;
    }


}

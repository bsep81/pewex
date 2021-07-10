package pl.sdacademy.pewex.product.service;

import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.mappers.ProductMapper;
import pl.sdacademy.pewex.product.model.ProductDetail;
import pl.sdacademy.pewex.product.repository.ProductRepository;

import java.util.Optional;


public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper productMapper;


    public ProductService(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    public ProductDetail get(Long id){

        if(id==null){
            return null;
        }

        Optional<ProductEntity> found = repository.findById(id);




        return found
                .flatMap(productMapper::mapEntityToProductDetail)
                .orElse(new ProductDetail());

    }
}

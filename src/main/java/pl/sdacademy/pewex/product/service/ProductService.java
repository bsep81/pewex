package pl.sdacademy.pewex.product.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.exceptions.ProductException;
import pl.sdacademy.pewex.product.mappers.ProductMappersFacade;
import pl.sdacademy.pewex.product.model.Product;
import pl.sdacademy.pewex.product.model.ProductDetail;
import pl.sdacademy.pewex.product.model.ProductListDTO;
import pl.sdacademy.pewex.product.repository.ProductRepository;
import pl.sdacademy.pewex.product.validators.ProductValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface{

    private final ProductRepository productRepository;
    private final ProductMappersFacade productMappersFacade;
    private final ProductValidator productValidator;

    public ProductService(ProductRepository productRepository, ProductMappersFacade productMappersFacade, ProductValidator productValidator) {
        this.productRepository = productRepository;
        this.productMappersFacade = productMappersFacade;
        this.productValidator = productValidator;
    }


    @Override
    public List<ProductListDTO> getProductList() {
        List<ProductListDTO> products = new ArrayList<>();
        productRepository.findAll().forEach(entity -> products.add(productMappersFacade.mapEntityToProductListDTO(entity).get()));

        return products;
    }

    @Override
    public ProductDetail getProductDetail(Long id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if(productEntityOptional.isEmpty()){
            return new ProductDetail();
        }
        return productMappersFacade.mapEntityToProductDetail(productEntityOptional.get()).get();
    }

    @Override
    public Product addProduct(Product product) {

        List<String> errors = productValidator.isValid(product);
        if (!errors.isEmpty()) {
            throw new ProductException(Strings.join(errors, ','));
        }

        ProductEntity created = productRepository.save(productMappersFacade.mapProductToEntity(product));
        return productMappersFacade.mapEntityToProduct(created).get();
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        productEntityOptional.ifPresent(productRepository::delete);
    }

    @Override
    public Product updateProduct(Product product) {

        return addProduct(product);
    }


}

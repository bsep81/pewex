package pl.sdacademy.pewex.product.mappers;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.model.Product;
import pl.sdacademy.pewex.product.model.ProductDetail;
import pl.sdacademy.pewex.product.model.ProductListDTO;

import java.util.Optional;

@Component
public class ProductMappersFacade {

    private final ProductListDTOMapper productListDTOMapper;
    private final ProductDetailsMapper productDetailsMapper;
    private final ProductMapper productMapper;

    public ProductMappersFacade(ProductListDTOMapper productListDTOMapper, ProductDetailsMapper productDetailsMapper, ProductMapper productMapper) {
        this.productListDTOMapper = productListDTOMapper;
        this.productDetailsMapper = productDetailsMapper;
        this.productMapper = productMapper;
    }

    public Optional<Product> mapEntityToProduct(ProductEntity entity){
        return productMapper.mapEntityToProduct(entity);
    }
    public ProductEntity mapProductToEntity(Product product){
        return productMapper.mapProductToEntity(product);
    }

    public Optional<ProductDetail> mapEntityToProductDetail(ProductEntity entity){
        return productDetailsMapper.mapEntityToProductDetail(entity);
    }
    public ProductEntity mapProductDetailToEntity(ProductDetail productDetail){
        return productDetailsMapper.mapProductDetailToEntity(productDetail);
    }

    public Optional<ProductListDTO> mapEntityToProductListDTO(ProductEntity entity){
        return productListDTOMapper.mapEntityToProductListDTO(entity);
    }
    public ProductEntity mapProductListDTOToEntity(ProductListDTO productListDTO){
        return productListDTOMapper.mapProductListDTOToEntity(productListDTO);
    }
}

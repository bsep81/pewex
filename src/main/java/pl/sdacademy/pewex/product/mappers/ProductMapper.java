package pl.sdacademy.pewex.product.mappers;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.model.ProductDetail;


import java.util.Optional;

@Component
public class ProductMapper {

    public Optional<ProductDetail> mapEntityToProductDetail(ProductEntity entity) {

        if (entity == null) {
            return Optional.empty();
        }

        ProductDetail productDetail = ProductDetail.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .rating(entity.getRating())
                .build();

        return Optional.of(productDetail);
    }

    public ProductEntity mapProductDetailToEntity(ProductDetail productDetail) {

        return ProductEntity.builder()
                .title(productDetail.getTitle())
                .price(productDetail.getPrice())
                .description(productDetail.getDescription())
                .rating(productDetail.getRating())
                .build();
    }

}

package pl.sdacademy.pewex.product.mappers;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.model.Product;


import java.util.Optional;

@Component
public class ProductMapper {

    public Optional<Product> mapEntityToProduct(ProductEntity entity) {

        if (entity == null) {
            return Optional.empty();
        }

        Product product = Product.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .rating(entity.getRating())
                .build();

        return Optional.of(product);
    }

    public ProductEntity mapProductToEntity(Product product) {

        return ProductEntity.builder()
                .id(product.getId())
                .title(product.getTitle())
                .author(product.getAuthor())
                .price(product.getPrice())
                .description(product.getDescription())
                .rating(product.getRating())
                .build();
    }

}

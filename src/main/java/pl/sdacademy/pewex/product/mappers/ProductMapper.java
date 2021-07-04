package pl.sdacademy.pewex.product.mappers;

import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.model.Product;


public class ProductMapper {
    public Product mapEntityToProduct(ProductEntity created) {
        if (created == null) {
            return null;
        }
        Product result = new Product();
        result.setId(created.getId());
        result.setTitle(created.getTitle());
        result.setAuthor(created.getAuthor());
        result.setPrice(created.getPrice());
        result.setDescription(created.getDescription());
        result.setRating(created.getRating());
        return result;
    }

    public ProductEntity mapProductToEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setTitle(product.getTitle());
        entity.setAuthor(product.getAuthor());
        entity.setPrice(product.getPrice());
        entity.setDescription(product.getDescription());
        entity.setRating(product.getRating());
        return entity;

    }
}


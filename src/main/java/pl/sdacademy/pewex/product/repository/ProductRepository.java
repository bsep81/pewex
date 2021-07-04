package pl.sdacademy.pewex.product.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.pewex.product.db.ProductEntity;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title);
    List<ProductEntity> findByAuthor(String author);
}

package pl.sdacademy.pewex.product.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.pewex.product.db.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

}

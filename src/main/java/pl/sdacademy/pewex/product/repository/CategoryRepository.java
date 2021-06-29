package pl.sdacademy.pewex.product.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.pewex.product.db.CategoryEntity;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}

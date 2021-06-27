package pl.sdacademy.pewex.order.db;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.pewex.order.model.ItemEntity;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
    Optional<ItemEntity> findByName(Long name);

}

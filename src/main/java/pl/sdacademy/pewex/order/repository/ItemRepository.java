package pl.sdacademy.pewex.order.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.pewex.order.db.ItemEntity;

public interface ItemRepository extends CrudRepository<ItemEntity, Long> {


}

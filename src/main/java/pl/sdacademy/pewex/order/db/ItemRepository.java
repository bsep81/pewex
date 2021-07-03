package pl.sdacademy.pewex.order.db;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.pewex.order.model.ItemEntity;

public interface ItemRepository extends CrudRepository<ItemEntity, Long> {


}

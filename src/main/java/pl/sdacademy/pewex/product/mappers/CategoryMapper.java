package pl.sdacademy.pewex.product.mappers;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.db.CategoryEntity;
import pl.sdacademy.pewex.product.model.Category;

import java.util.Optional;

@Component
public class CategoryMapper {

    public Optional<Category> mapEntityToCategory(CategoryEntity entity) {

        if (entity == null) {
            return Optional.empty();
        }

        Category category = Category.builder()
                .id(entity.getId())
                .name(entity.getName())
                .parentId(entity.getParentId())
                .build();

        return Optional.of(category);
    }

    public CategoryEntity mapCategoryToEntity(Category category) {

        return CategoryEntity.builder()
                .name(category.getName())
                .parentId(category.getParentId())
                .build();
    }
}

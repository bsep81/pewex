package pl.sdacademy.pewex.product.mappers;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.db.CategoryEntity;
import pl.sdacademy.pewex.product.model.Category;

@Component
public class CategoryMapper {

    public Category mapEntityToCategory(CategoryEntity entity){
        if (entity == null) {
            return null;
        }

        return Category.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public CategoryEntity mapCategoryToEntity(Category category){

        return CategoryEntity.builder()
                .name(category.getName())
                .build();
    }
}

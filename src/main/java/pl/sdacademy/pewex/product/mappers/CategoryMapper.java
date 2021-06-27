package pl.sdacademy.pewex.mappers;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.db.CategoryEntity;
import pl.sdacademy.pewex.product.model.Category;

@Component
public class CategoryMapper {

    public Category mapEntityToCategory(CategoryEntity entity){
        if (entity == null) {
            return null;
        }

        Category category = new Category();

        category.setId(entity.getId());
        category.setParentId(entity.getParentId());
        category.setName(entity.getName());
        category.setCreatedBy(entity.getCreatedBy());
        category.setCreatedDate(entity.getCreatedDate());
        category.setModifiedBy(entity.getModifiedBy());
        category.setModifiedDate(entity.getModifiedDate());

        return category;
    }

    public CategoryEntity mapCategoryToEntity(Category category){
        CategoryEntity entity = new CategoryEntity();

        entity.setParentId(category.getParentId());
        entity.setName(category.getName());
        entity.setCreatedBy(category.getCreatedBy());
        entity.setCreatedDate(category.getCreatedDate());
        entity.setModifiedBy(category.getModifiedBy());
        entity.setModifiedDate(category.getModifiedDate());

        return entity;
    }
}

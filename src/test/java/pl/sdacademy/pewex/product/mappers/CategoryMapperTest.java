package pl.sdacademy.pewex.product.mappers;

import org.junit.jupiter.api.Test;
import pl.sdacademy.pewex.product.db.CategoryEntity;
import pl.sdacademy.pewex.product.model.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {

    @Test
    void shouldMapEntityToCategory(){
        CategoryEntity entity = CategoryEntity.builder()
                .id(1L)
                .name("Test name")
                .parentId(10L)
                .build();
        Category category = Category.builder()
                .id(1L)
                .name("Test name")
                .parentId(10L)
                .build();

        CategoryMapper mapper = new CategoryMapper();

        Category result = mapper.mapEntityToCategory(entity).get();

        assertEquals(category, result);

        ;
    }

}
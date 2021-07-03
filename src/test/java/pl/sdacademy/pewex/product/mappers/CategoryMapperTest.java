package pl.sdacademy.pewex.product.mappers;

import org.junit.jupiter.api.Test;
import pl.sdacademy.pewex.product.db.CategoryEntity;
import pl.sdacademy.pewex.product.model.Category;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CategoryMapperTest {

    private CategoryMapper sut = new CategoryMapper();
    // positive path
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

        Optional<Category> result = sut.mapEntityToCategory(entity);

        assertThat(result)
            .isNotEmpty()
            .contains(category);
    }

    @Test
    void shouldReturnEmptyOptionalIfNullEntity() {

        Optional<Category> result = sut.mapEntityToCategory(null);

        assertThat(result).isEmpty();
    }
}

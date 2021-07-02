package pl.sdacademy.pewex.product.service;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.db.CategoryEntity;
import pl.sdacademy.pewex.product.mappers.CategoryMapper;
import pl.sdacademy.pewex.product.model.Category;
import pl.sdacademy.pewex.product.repository.CategoryRepository;

@Component
public class CategoryService {
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(String name, Long parentId){
        CategoryEntity entity = CategoryEntity.builder()
                .name(name)
                .parentId(parentId)
                .build();

        CategoryEntity created = categoryRepository.save(entity);
        return categoryMapper.mapEntityToCategory(created).get();
    }
}

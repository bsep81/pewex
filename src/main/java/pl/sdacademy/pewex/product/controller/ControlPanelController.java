package pl.sdacademy.pewex.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sdacademy.pewex.product.db.CategoryEntity;
import pl.sdacademy.pewex.product.mappers.CategoryMapper;
import pl.sdacademy.pewex.product.model.Category;
import pl.sdacademy.pewex.product.repository.CategoryRepository;

@Controller
@RequestMapping("/api/controlPanel")
public class ControlPanelController {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public ControlPanelController(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/addCategory")
    public String addCategory(){
        return "add-category";
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestParam() String name,
                                @RequestParam() Long parentId){
        CategoryEntity entity = CategoryEntity.builder()
                .name(name)
                .parentId(parentId)
                .build();

        CategoryEntity created = categoryRepository.save(entity);
        return categoryMapper.mapEntityToCategory(created).get();
    }
}

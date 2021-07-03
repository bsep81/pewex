package pl.sdacademy.pewex.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.pewex.product.model.Category;
import pl.sdacademy.pewex.product.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    public Category addCategory(Category category) {
        return categoryService.addCategory(category);
    }
}

package pl.sdacademy.pewex.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sdacademy.pewex.product.model.Category;
import pl.sdacademy.pewex.product.service.CategoryService;

@Controller
@RequestMapping("/api/controlPanel")
public class ControlPanelController {


    private final CategoryService categoryService;

    public ControlPanelController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/addCategory")
    public String addCategory(){
        return "add-category";
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestParam() String name,
                                @RequestParam() Long parentId){

        return categoryService.addCategory(name, parentId);
    }
}

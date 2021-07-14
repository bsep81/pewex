package pl.sdacademy.pewex.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.sdacademy.pewex.product.model.Product;
import pl.sdacademy.pewex.product.model.ProductDetail;
import pl.sdacademy.pewex.product.model.ProductListDTO;
import pl.sdacademy.pewex.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<ProductListDTO> getList(){
        return productService.getProductList();
    }

    @GetMapping("/{id}")
    public ProductDetail getProductDetail(@PathVariable(name = "id") Long id){
        return productService.getProductDetail(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }


}

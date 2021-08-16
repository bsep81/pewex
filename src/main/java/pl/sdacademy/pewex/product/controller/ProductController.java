package pl.sdacademy.pewex.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<ProductListDTO> getList(){
        LOG.info("Getting product list");
        return productService.getProductList();
    }

    @GetMapping("/{id}")
    public ProductDetail getProductDetail(@PathVariable(name = "id") Long id){
        LOG.info("Getting product details for id={}", id);
        return productService.getProductDetail(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    @Secured("ROLE_ADMIN")
    public Product addProduct(@RequestBody Product product){
        LOG.info("Adding product {} to database", product.getTitle());
        return productService.saveProduct(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public void deleteProduct(@PathVariable(name = "id") Long id){
        LOG.info("Attempting to delete product with id={} from database", id);
        productService.deleteProduct(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping
    @Secured("ROLE_ADMIN")
    public Product updateProduct(@RequestBody Product product){
        LOG.info("Attempting to update product with id={}", product.getId());
        return productService.updateProduct(product);
    }

}

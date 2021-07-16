package pl.sdacademy.pewex.product.service;

import pl.sdacademy.pewex.product.model.Product;
import pl.sdacademy.pewex.product.model.ProductDetail;
import pl.sdacademy.pewex.product.model.ProductListDTO;

import java.util.List;

public interface ProductServiceInterface {

    List<ProductListDTO> getProductList();

    ProductDetail getProductDetail(Long id);

    Product addProduct(Product product);

    void deleteProduct(Long id);

}

package pl.sdacademy.pewex.product.service;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.model.ProductDetail;
import pl.sdacademy.pewex.product.model.ProductListDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService implements ProductServiceInterface{
    @Override
    public List<ProductListDTO> getProductList() {
        return new ArrayList<>();
    }

    @Override
    public ProductDetail getProductDetail(Long id) {
        return null;
    }
}

package pl.sdacademy.pewex.product.validators;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {

    public List<String> isValid(Product product){
        List<String> result = new ArrayList<>();

        if(product.getAuthor() == null || product.getAuthor().isEmpty()){
            result.add("Field 'author' can not be empty");
        }
        if(product.getTitle() == null || product.getTitle().isEmpty()){
            result.add("Field 'title' can not be empty");
        }
        if(product.getPrice() == null){
            result.add("Product nedds to hava a price");
        }

        return result;
    }

}

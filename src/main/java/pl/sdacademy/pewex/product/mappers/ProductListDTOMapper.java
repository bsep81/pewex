package pl.sdacademy.pewex.product.mappers;

import org.springframework.stereotype.Component;
import pl.sdacademy.pewex.product.db.ProductEntity;
import pl.sdacademy.pewex.product.model.ProductListDTO;

import java.util.Optional;

@Component
public class ProductListDTOMapper {
    public Optional<ProductListDTO> mapEntityToProductListDTO(ProductEntity entity) {

        if (entity == null) {
            return Optional.empty();
        }

        ProductListDTO productListDTO = ProductListDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .price(entity.getPrice())
                .rating(entity.getRating())
                .build();

        return Optional.of(productListDTO);
    }

    public ProductEntity mapProductListDTOToEntity(ProductListDTO productListDTO) {

        return ProductEntity.builder()
                .title(productListDTO.getTitle())
                .price(productListDTO.getPrice())
                .rating(productListDTO.getRating())
                .build();
    }
}

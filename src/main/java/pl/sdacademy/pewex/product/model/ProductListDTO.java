package pl.sdacademy.pewex.product.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductListDTO {

    private Long id;
    private String title;
    private BigDecimal price;
    private BigDecimal rating;
}

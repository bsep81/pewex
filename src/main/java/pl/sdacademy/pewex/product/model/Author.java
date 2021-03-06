package pl.sdacademy.pewex.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    private Long id;
    private String name;
    private String surname;
}

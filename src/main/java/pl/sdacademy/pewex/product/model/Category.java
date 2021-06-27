package pl.sdacademy.pewex.product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    private Long id;
    private Long parentId;
    private String name;
    private List<Long> children;

}

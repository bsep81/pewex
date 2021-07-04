package pl.sdacademy.pewex.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedProduct {
    private Long Id;
    private int howMany;
}

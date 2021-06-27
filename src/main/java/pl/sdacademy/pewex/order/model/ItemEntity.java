package pl.sdacademy.pewex.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {

    @Id
    private Long id;

    @Column(name="id_order")
    private Long idOrder;

    @Column(name="id_product")
    private Long idProduct;

    private int count;

    private float price;

}

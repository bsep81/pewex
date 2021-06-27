package pl.sdacademy.pewex.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "items")
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    private int id;

    @Column(name="id_order")
    private int idOrder;

    @Column(name="id_product")
    private int idProduct;

    private int count;

    private float price;

}

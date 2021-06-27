package pl.sdacademy.pewex.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private int id;

    @Column(name="id_user")
    private int idUser;

    @Column(name="id_address_delivery")
    private int idAddressDelivery;

    private LocalDateTime date;

    private Status status;

}

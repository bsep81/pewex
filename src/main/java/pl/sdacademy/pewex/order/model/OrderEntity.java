package pl.sdacademy.pewex.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Data
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    private Long id;

    @Column(name="id_user")
    private Long idUser;

    @Column(name="id_address_delivery")
    private Long idAddressDelivery;

    private LocalDateTime date;

    private Status status;

}

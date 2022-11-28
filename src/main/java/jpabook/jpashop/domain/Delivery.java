package jpabook.jpashop.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DELIVERY_ID")
    private Long id;


    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;

    private String zipcode;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus status;

}

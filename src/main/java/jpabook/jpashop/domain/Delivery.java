package jpabook.jpashop.domain;


import jpabook.jpashop.domain.childClass.Address;
import jpabook.jpashop.domain.status.DeliveryStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Delivery extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DELIVERY_ID")
    private Long id;


    @OneToOne(mappedBy = "delivery")
    private Order order;


    @Embedded
    private Address address;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus status;

}

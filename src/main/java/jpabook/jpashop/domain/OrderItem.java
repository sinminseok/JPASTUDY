package jpabook.jpashop.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ORDER_ITEM")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice;

    private int count;
}

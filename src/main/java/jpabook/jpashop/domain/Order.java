package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate; // 주문시가ㅣㄴ

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status; //주문 상태
}

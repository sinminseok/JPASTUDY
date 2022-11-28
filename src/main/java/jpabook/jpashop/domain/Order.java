package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    private Date orderDate;


    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus status;

    public void MemberSET(Member member){
        //기존관계 제거
        if(this.member != null){
            this.member.getOrders().remove(this);
        }
        this.member = member;

        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void DeliverySET(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

}

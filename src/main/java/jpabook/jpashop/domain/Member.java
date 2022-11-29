package jpabook.jpashop.domain;

import jpabook.jpashop.domain.childClass.Address;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders;
}

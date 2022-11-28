package jpabook.jpashop.domain;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String city;

    private String STREET;

    private String zipcode;

    @OneToMany(mappedBy = "member")
    private List<Order> orders;
}

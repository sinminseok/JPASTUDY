package jpabook.jpashop.domain;


import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {
    private Date createdDate;
    private Date lastModifiedDAte;
}

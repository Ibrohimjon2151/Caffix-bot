package com.example.caffix.DBconfig.entity;

import com.example.caffix.DBconfig.entity.template.AbcEntityId;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderProduct extends AbcEntityId {

    private String name;

    private Integer amount;

    private Long price;

    private Long userId;

    @ManyToOne
    private Basket basket;

    private String date;

}

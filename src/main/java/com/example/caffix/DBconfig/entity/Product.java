package com.example.caffix.DBconfig.entity;

import com.example.caffix.DBconfig.entity.template.AbcEntityId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbcEntityId {
    private String name;

    private Integer amount;

    private Long price;

    private Long userId;

}

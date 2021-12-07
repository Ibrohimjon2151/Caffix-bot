package com.example.caffix.DBconfig.entity;

import com.example.caffix.DBconfig.entity.template.AbcEntityId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPrice extends AbcEntityId {

    private String name;

    private Long price;
}

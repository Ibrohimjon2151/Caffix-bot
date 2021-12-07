package com.example.caffix.DBconfig.entity;

import com.example.caffix.DBconfig.entity.template.AbcEntityId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Basket extends AbcEntityId {
    @OneToOne
    private User user;

    private Long price;

    private Long chatId;
}

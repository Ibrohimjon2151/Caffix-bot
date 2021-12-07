package com.example.caffix.DBconfig.entity;

import com.example.caffix.DBconfig.entity.template.AbcEntityId;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User extends AbcEntityId {
    private String name;

    private String state;

    private String phoneNumber;

    private Double locationLongitude;

    private Double locationLatitude;

    private Long chatId;

    private String location;

}

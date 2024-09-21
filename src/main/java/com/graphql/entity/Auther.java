package com.graphql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Auther {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToOne
    private Book book;

    public Auther(String name) {
        this.name = name;
    }
}

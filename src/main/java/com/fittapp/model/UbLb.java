package com.fittapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "upper_body_lower_body")
@Getter
@Setter
public class UbLb {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer ex1;
    @Column
    private Integer ex2;
    @Column
    private Integer ex3;
    @Column
    private Integer ex4;
    @Column
    private Integer ex5;
    @Column
    private Integer ex6;
}

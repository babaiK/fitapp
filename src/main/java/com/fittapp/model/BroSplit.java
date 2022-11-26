package com.fittapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bro_split")
@Getter
@Setter
public class BroSplit {
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

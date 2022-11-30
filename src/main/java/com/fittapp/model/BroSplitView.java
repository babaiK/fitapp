package com.fittapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bro_split_view")
@Getter
@Setter
public class BroSplitView {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "ex1")
    private String ex1;

    @Column(name = "ex2")
    private String ex2;

    @Column(name = "ex3")
    private String ex3;

    @Column(name = "ex4")
    private String ex4;

    @Column(name = "ex5")
    private String ex5;

    @Column(name = "ex6")
    private String ex6;

}

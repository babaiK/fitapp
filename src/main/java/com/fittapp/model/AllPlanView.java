package com.fittapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "all_plan_view")
@Getter
@Setter
public class AllPlanView {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "fk")
    private Long fk;

    @Column(name = "plan_type")
    private Long planType;

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

package com.fittapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "workoutview")
@Getter
@Setter
public class WorkoutView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "exercise1")
    private String exercise1;

    @Column(name = "exercise2")
    private String exercise2;

    @Column(name = "exercise3")
    private String exercise3;

    @Column(name = "exercise4")
    private String exercise4;

    @Column(name = "exercise5")
    private String exercise5;

    @Column(name = "exercise6")
    private String exercise6;

    @Column(name = "join_this_plan")
    private Integer join_this_plan;

    @Column(name = "type_of_plan")
    private Integer type_of_plan;

}

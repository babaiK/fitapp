package com.fittapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "workout_plan_day")
@Getter
@Setter
public class WorkoutPlanDay {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ex1")
    private Integer ex1;
    @Column(name = "ex2")
    private Integer ex2;
    @Column(name = "ex3")
    private Integer ex3;
    @Column(name = "ex4")
    private Integer ex4;
    @Column(name = "ex5")
    private Integer ex5;
    @Column(name = "ex6")
    private Integer ex6;
    @Column(name = "type_of_plan")
    private Integer typeOfPlan;
    @Column(name = "join_this_plan")
    private Integer joinThisPlan;

}

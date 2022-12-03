package com.fittapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="muscle_group")
@Getter
@Setter
public class MuscleGroup {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer ppl; //1: push, 2: pull, 3: leg

    @Column
    private Integer lowerBody; //1: lowerbody, 0: upperbody

    @Column
    private Integer prio;
}

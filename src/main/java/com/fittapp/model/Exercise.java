package com.fittapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "exercise")
@Getter
@Setter
public class Exercise {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "muscle_group_id")
    private Integer muscleGroupId;

    @Column(name = "name")
    private String name;
}

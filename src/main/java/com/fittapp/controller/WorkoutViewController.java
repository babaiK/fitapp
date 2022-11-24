package com.fittapp.controller;

import com.fittapp.model.WorkoutView;
import com.fittapp.repository.WorkoutViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/workoutview")
public class WorkoutViewController {

    @Autowired
    WorkoutViewRepository workoutViewRepository;

    @GetMapping("/{id}")
    public List<WorkoutView> list(@PathVariable Integer id){
        List<WorkoutView> list = workoutViewRepository.addWorkoutView(Collections.singleton(id));
        return list;
    }
}

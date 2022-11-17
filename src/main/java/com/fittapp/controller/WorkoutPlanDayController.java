package com.fittapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fittapp.model.Exercise;
import com.fittapp.repository.WorkoutPlanDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/generate")
public class WorkoutPlanDayController {

    @Autowired
    WorkoutPlanDayRepository workoutPlanDayRepository;

    private final ObjectMapper jsonMapper;

    public WorkoutPlanDayController(ObjectMapper jsonMapper){this.jsonMapper = jsonMapper;}


}

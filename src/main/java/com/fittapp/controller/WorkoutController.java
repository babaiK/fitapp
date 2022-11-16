package com.fittapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fittapp.model.Exercise;
import com.fittapp.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController{

//    @Autowired
//    WorkoutRepository workoutRepository;
//
//    private final ObjectMapper jsonMapper;
//
//    public WorkoutController(ObjectMapper jsonMapper){this.jsonMapper = jsonMapper;}
//
//    @GetMapping("/chest")
//    public ResponseEntity<String> getRandomChest() throws JsonProcessingException {
//        Exercise e = workoutRepository.randomChest();
//        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(e), HttpStatus.OK);
//    }
}

package com.fittapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fittapp.model.Exercise;
import com.fittapp.repository.ExerciseRepository;
//import com.fittapp.repository.WorkoutPlanDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    private final ObjectMapper jsonMapper;

    public ExerciseController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/list")
    //@Transactional
    public List<Exercise> list(){
        List<Exercise> list = exerciseRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }

    @GetMapping("/{id}")
    public Exercise get(@PathVariable Integer id) {
        Exercise exercise = exerciseRepository.findById(id).get();
        System.out.println("exercise: " + exercise);
        return exercise;
    }

    @RequestMapping(value = "/randomId",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> getRandomId() {
        Random random = new Random();
        Integer randomId = random.nextInt(2) +1;
        Exercise exercise = exerciseRepository.findById(randomId).get();
        System.out.println("exercise: " + exercise);

        return new ResponseEntity<>(exercise.getName(), HttpStatus.OK);
    }

    @PostMapping("")
    public Exercise insert(@RequestBody Exercise exercise){
        Exercise saved = exerciseRepository.save(exercise);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Exercise> update(
            @PathVariable Integer id,
            @RequestBody Exercise details){
        Exercise exercise = exerciseRepository.findById(id).get();
        exercise.setName(details.getName());
        exercise.setName(details.getName());
        exercise.setMuscleGroupId((details.getMuscleGroupId()));

        final Exercise updated = exerciseRepository.save(exercise);
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Integer id){
        Exercise exercise = exerciseRepository.findById(id).get();

        exerciseRepository.delete(exercise);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

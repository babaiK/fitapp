package com.fittapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fittapp.model.Exercise;
import com.fittapp.model.MuscleGroup;
import com.fittapp.repository.MuscleGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/musclegroup")
public class MuscleGroupController {

    @Autowired
    MuscleGroupRepository muscleGroupRepository;

    private final ObjectMapper jsonMapper;

    public MuscleGroupController(ObjectMapper jsonMapper){
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/list")
    //@Transactional
    public List<MuscleGroup> list(){
        List<MuscleGroup> list = muscleGroupRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }

    @GetMapping("/{id}")
    public MuscleGroup get(@PathVariable Long id) {
        MuscleGroup muscleGroup = muscleGroupRepository.findById(id).get();
        System.out.println("exercise: " + muscleGroup);
        return muscleGroup;
    }

    @RequestMapping(value = "/randomId",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> getRandomId() {
        Random random = new Random();
        Integer randomId = random.nextInt(2) +1;
        MuscleGroup muscleGroup = muscleGroupRepository.findById(Long.valueOf(randomId)).get();
        System.out.println("exercise: " + muscleGroup);

        return new ResponseEntity<>(muscleGroup.getName(), HttpStatus.OK);
    }

    @PostMapping("")
    public MuscleGroup insert(@RequestBody MuscleGroup muscleGroup){
        MuscleGroup saved = muscleGroupRepository.save(muscleGroup);
        return saved;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MuscleGroup> update(
            @PathVariable Long id,
            @RequestBody MuscleGroup details){
        MuscleGroup muscleGroup = muscleGroupRepository.findById(id).get();
        muscleGroup.setName(details.getName());
        muscleGroup.setPpl(details.getPpl());
        muscleGroup.setLowerBody(details.getLowerBody());
        muscleGroup.setPrio(details.getPrio());
        //exercise.setMuscleGroupId((details.getMuscleGroupId()));

        final MuscleGroup updated = muscleGroupRepository.save(muscleGroup);
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Long id){
        MuscleGroup muscleGroup = muscleGroupRepository.findById(id).get();

        muscleGroupRepository.delete(muscleGroup);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }



}

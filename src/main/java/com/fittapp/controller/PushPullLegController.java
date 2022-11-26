package com.fittapp.controller;

import com.fittapp.model.Exercise;
import com.fittapp.model.PushPullLeg;
import com.fittapp.repository.ExerciseRepository;
import com.fittapp.repository.PushPullLegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("generate/ppl")
public class PushPullLegController {

    @Autowired
    PushPullLegRepository pushPullLegRepository;

    @Autowired
    ExerciseRepository exerciseRepository;


    @GetMapping("")
    public String PushPullLeg(){

        addPlan(2,3,4,1,8,2);
        addPlan(3,3,5,1,7,2);
        addLeg(9,4,1,2);

        return "Workout plan Push/Pull/Leg is ready!";

    }

    @GetMapping("/list")
    //@Transactional
    public List<PushPullLeg> list(){
        List<PushPullLeg> list = pushPullLegRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Long id){
        Map<String, Boolean> response = new HashMap<>();
        if(id%3==0){
            for(long i = id; i>id-3; i--){
                PushPullLeg pushPullLeg = pushPullLegRepository.findById(i).get();
                pushPullLegRepository.delete(pushPullLeg);
            }
            response.put("deleted", Boolean.TRUE);
        }
        else {
            response.put("id mod x is false", Boolean.FALSE);
        }
        return response;
    }

    public String addPlan(int prio1id, int prio1limit, int prio2id, int prio2limit, int prio3id, int prio3limit){

        List<Exercise> prio1= exerciseRepository.addAllExercise(Collections.singleton(prio1id), Collections.singleton(prio1limit));
        List<Exercise> prio2 = exerciseRepository.addAllExercise(Collections.singleton(prio2id), Collections.singleton(prio2limit));
        List<Exercise> prio3= exerciseRepository.addAllExercise(Collections.singleton(prio3id), Collections.singleton(prio3limit));

        PushPullLeg pushPullLeg = new PushPullLeg();
        pushPullLeg.setEx1(prio1.get(0).getId());
        pushPullLeg.setEx2(prio1.get(1).getId());
        pushPullLeg.setEx3(prio1.get(2).getId());
        pushPullLeg.setEx4(prio2.get(0).getId());
        pushPullLeg.setEx5(prio3.get(0).getId());
        pushPullLeg.setEx6(prio3.get(1).getId());

        pushPullLegRepository.save(pushPullLeg);

        return "Workoutplan is ready!";

    }
    public String addLeg(int prio1id, int prio1limit, int prio2id, int prio2limit){

        List<Exercise> leg= exerciseRepository.addAllExercise(Collections.singleton(prio1id), Collections.singleton(prio1limit));
        List<Exercise> culve = exerciseRepository.addAllExercise(Collections.singleton(prio2id), Collections.singleton(prio2limit));

        PushPullLeg wpdleg = new PushPullLeg();
        wpdleg.setEx1(leg.get(0).getId());
        wpdleg.setEx2(leg.get(1).getId());
        wpdleg.setEx3(leg.get(2).getId());
        wpdleg.setEx4(leg.get(3).getId());
        wpdleg.setEx5(culve.get(0).getId());
        wpdleg.setEx6(culve.get(1).getId());

        pushPullLegRepository.save(wpdleg);

        return "Workoutplan is ready!";
    }
}

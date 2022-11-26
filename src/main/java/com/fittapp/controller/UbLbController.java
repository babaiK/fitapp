package com.fittapp.controller;

import com.fittapp.model.Exercise;
import com.fittapp.model.PushPullLeg;
import com.fittapp.model.UbLb;
import com.fittapp.repository.ExerciseRepository;
import com.fittapp.repository.UbLbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("generate/ublb")
public class UbLbController {

    @Autowired
    UbLbRepository ubLbRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    @GetMapping("")
    public String Ublb(){

        List<Exercise> chest= exerciseRepository.addAllExercise(Collections.singleton(2), Collections.singleton(2));
        List<Exercise> back = exerciseRepository.addAllExercise(Collections.singleton(3), Collections.singleton(2));
        List<Exercise> triceps= exerciseRepository.addAllExercise(Collections.singleton(8), Collections.singleton(1));
        List<Exercise> biceps= exerciseRepository.addAllExercise(Collections.singleton(7), Collections.singleton(1));

        UbLb wpdupper = new UbLb();
        wpdupper.setEx1(chest.get(0).getId());
        wpdupper.setEx2(chest.get(1).getId());
        wpdupper.setEx3(back.get(0).getId());
        wpdupper.setEx4(back.get(1).getId());
        wpdupper.setEx5(triceps.get(0).getId());
        wpdupper.setEx6(biceps.get(0).getId());

        ubLbRepository.save(wpdupper);

        addLeg(9,4,1,2);

        return "Workout plan Upper body - Lower body is ready!";
    }

    @GetMapping("/list")
    //@Transactional
    public List<UbLb> list(){
        List<UbLb> list = ubLbRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Long id){
        Map<String, Boolean> response = new HashMap<>();
        if(id%2==0){
            for(long i = id; i>id-2; i--){
                UbLb ubLb = ubLbRepository.findById(i).get();
                ubLbRepository.delete(ubLb);
            }
            response.put("deleted", Boolean.TRUE);
        }
        else {
            response.put("id mod x is false", Boolean.FALSE);
        }
        return response;
    }

    public String addLeg(int prio1id, int prio1limit, int prio2id, int prio2limit){

        List<Exercise> leg= exerciseRepository.addAllExercise(Collections.singleton(prio1id), Collections.singleton(prio1limit));
        List<Exercise> culve = exerciseRepository.addAllExercise(Collections.singleton(prio2id), Collections.singleton(prio2limit));

        UbLb wpdleg = new UbLb();
        wpdleg.setEx1(leg.get(0).getId());
        wpdleg.setEx2(leg.get(1).getId());
        wpdleg.setEx3(leg.get(2).getId());
        wpdleg.setEx4(leg.get(3).getId());
        wpdleg.setEx5(culve.get(0).getId());
        wpdleg.setEx6(culve.get(1).getId());

        ubLbRepository.save(wpdleg);

        return "Workoutplan is ready!";
    }
}

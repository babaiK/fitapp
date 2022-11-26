package com.fittapp.controller;

import com.fittapp.model.BroSplit;
import com.fittapp.model.Exercise;
import com.fittapp.model.PushPullLeg;
import com.fittapp.repository.BroSplitRepository;
import com.fittapp.repository.ExerciseRepository;
import com.fittapp.repository.PushPullLegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/generate/brosplit")
public class BroSplitController {
    @Autowired
    BroSplitRepository broSplitRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    @GetMapping("")
    public String BroSplit(){

        addChestorBack(2); //chest id
        addChestorBack(3); //back id
        List<Exercise> fshoulder = exerciseRepository.addAllExercise(Collections.singleton(4), Collections.singleton(2));
        List<Exercise> sshoulder = exerciseRepository.addAllExercise(Collections.singleton(5), Collections.singleton(2));
        List<Exercise> rshoulder = exerciseRepository.addAllExercise(Collections.singleton(6), Collections.singleton(2));
        List<Exercise> biceps= exerciseRepository.addAllExercise(Collections.singleton(7), Collections.singleton(3));
        List<Exercise> triceps= exerciseRepository.addAllExercise(Collections.singleton(8), Collections.singleton(3));


        BroSplit shoulders = new BroSplit();
        shoulders.setEx1(fshoulder.get(0).getId());
        shoulders.setEx2(fshoulder.get(1).getId());
        shoulders.setEx3(sshoulder.get(0).getId());
        shoulders.setEx4(sshoulder.get(1).getId());
        shoulders.setEx5(rshoulder.get(0).getId());
        shoulders.setEx6(rshoulder.get(1).getId());

        broSplitRepository.save(shoulders);

        BroSplit arms = new BroSplit();
        arms.setEx1(biceps.get(0).getId());
        arms.setEx2(biceps.get(1).getId());
        arms.setEx3(biceps.get(2).getId());
        arms.setEx4(triceps.get(0).getId());
        arms.setEx5(triceps.get(1).getId());
        arms.setEx6(triceps.get(2).getId());

        broSplitRepository.save(arms);

        addLeg( 9,4,1,2);

        return "Workout plan Bro Split is ready!";
    }

    @GetMapping("/list")
    //@Transactional
    public List<BroSplit> list(){
        List<BroSplit> list = broSplitRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Long id){
        Map<String, Boolean> response = new HashMap<>();
        if(id%5==0){
            for(long i = id; i>id-5; i--){
                BroSplit broSplit = broSplitRepository.findById(i).get();
                broSplitRepository.delete(broSplit);
            }
            response.put("deleted", Boolean.TRUE);
        }
        else {
            response.put("id mod x is false", Boolean.FALSE);
        }
        return response;
    }

    public String addChestorBack(int id){

        List<Exercise> list= exerciseRepository.addAllExercise(Collections.singleton(id), Collections.singleton(6));
        BroSplit chestBack = new BroSplit();
        chestBack.setEx1(list.get(0).getId());
        chestBack.setEx2(list.get(1).getId());
        chestBack.setEx3(list.get(2).getId());
        chestBack.setEx4(list.get(3).getId());
        chestBack.setEx5(list.get(4).getId());
        chestBack.setEx6(list.get(5).getId());

        broSplitRepository.save(chestBack);

        return "Workoutplan is ready!";
    }

    public String addLeg(int prio1id, int prio1limit, int prio2id, int prio2limit){

        List<Exercise> leg= exerciseRepository.addAllExercise(Collections.singleton(prio1id), Collections.singleton(prio1limit));
        List<Exercise> culve = exerciseRepository.addAllExercise(Collections.singleton(prio2id), Collections.singleton(prio2limit));

        BroSplit wpdleg = new BroSplit();
        wpdleg.setEx1(leg.get(0).getId());
        wpdleg.setEx2(leg.get(1).getId());
        wpdleg.setEx3(leg.get(2).getId());
        wpdleg.setEx4(leg.get(3).getId());
        wpdleg.setEx5(culve.get(0).getId());
        wpdleg.setEx6(culve.get(1).getId());

        broSplitRepository.save(wpdleg);

        return "Workoutplan is ready!";
    }
}

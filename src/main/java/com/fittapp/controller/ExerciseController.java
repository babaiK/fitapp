package com.fittapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fittapp.model.Exercise;
import com.fittapp.model.WorkoutPlanDay;
import com.fittapp.repository.ExerciseRepository;
import com.fittapp.repository.WorkoutPlanDayRepository;
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

    @Autowired
    WorkoutPlanDayRepository workoutPlanDayRepository;
    private final ObjectMapper jsonMapper;

    public ExerciseController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    //public Integer actualIndex = exerciseRepository.lastIndex()+1;

    @GetMapping("/list")
    //@Transactional
    public List<Exercise> list(){
        List<Exercise> list = exerciseRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }

    @GetMapping("/{id}")
    public Exercise get(@PathVariable Long id) {
        Exercise exercise = exerciseRepository.findById(id).get();
        System.out.println("exercise: " + exercise);
        return exercise;
    }

    @RequestMapping(value = "/randomId",method = RequestMethod.GET,produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> getRandomId() {
        Random random = new Random();
        Integer randomId = random.nextInt(2) +1;
        Exercise exercise = exerciseRepository.findById(Long.valueOf(randomId)).get();
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
            @PathVariable Long id,
            @RequestBody Exercise details){
        Exercise exercise = exerciseRepository.findById(id).get();
        exercise.setName(details.getName());
        exercise.setName(details.getName());
        exercise.setMuscleGroupId((details.getMuscleGroupId()));

        final Exercise updated = exerciseRepository.save(exercise);
        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Long id){
        Exercise exercise = exerciseRepository.findById(id).get();

        exerciseRepository.delete(exercise);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/generate/ppl")
    public String getPpl() {

        Integer actualIndex = exerciseRepository.lastIndex()+1;

        addPlan(actualIndex,2,3,4,1,8,2,1);
        addPlan(actualIndex,3,3,5,1,7,2,2);
        addLeg(actualIndex, 9,4,1,2,3);

        return "Workout plan Push/Pull/Leg is ready!";
    }

    @GetMapping("/generate/ublb")
    public String getUblb(){

        Integer actualIndex = exerciseRepository.lastIndex()+1;


        List<Exercise> chest= exerciseRepository.addAllExercise(Collections.singleton(2), Collections.singleton(2));
        List<Exercise> back = exerciseRepository.addAllExercise(Collections.singleton(3), Collections.singleton(2));
        List<Exercise> triceps= exerciseRepository.addAllExercise(Collections.singleton(8), Collections.singleton(1));
        List<Exercise> biceps= exerciseRepository.addAllExercise(Collections.singleton(7), Collections.singleton(1));

        WorkoutPlanDay wpdupper = new WorkoutPlanDay();
        wpdupper.setEx1(chest.get(0).getId());
        wpdupper.setEx2(chest.get(1).getId());
        wpdupper.setEx3(back.get(0).getId());
        wpdupper.setEx4(back.get(1).getId());
        wpdupper.setEx5(triceps.get(0).getId());
        wpdupper.setEx6(biceps.get(0).getId());
        wpdupper.setTypeOfPlan(4);
        wpdupper.setJoinThisPlan(actualIndex);

        workoutPlanDayRepository.save(wpdupper);

        addLeg(actualIndex, 9,4,1,2,5);

        return "Workout plan Upper body - Lower body is ready!";
    }

    @GetMapping("/generate/bs")
    public String getSb(){

        Integer actualIndex = exerciseRepository.lastIndex()+1;

        List<Exercise> chest= exerciseRepository.addAllExercise(Collections.singleton(2), Collections.singleton(6));
        List<Exercise> back = exerciseRepository.addAllExercise(Collections.singleton(3), Collections.singleton(6));
        List<Exercise> fshoulder = exerciseRepository.addAllExercise(Collections.singleton(4), Collections.singleton(2));
        List<Exercise> sshoulder = exerciseRepository.addAllExercise(Collections.singleton(5), Collections.singleton(2));
        List<Exercise> rshoulder = exerciseRepository.addAllExercise(Collections.singleton(6), Collections.singleton(2));
        List<Exercise> biceps= exerciseRepository.addAllExercise(Collections.singleton(7), Collections.singleton(3));
        List<Exercise> triceps= exerciseRepository.addAllExercise(Collections.singleton(8), Collections.singleton(3));

        WorkoutPlanDay wpdchest = new WorkoutPlanDay();
        wpdchest.setEx1(chest.get(0).getId());
        wpdchest.setEx2(chest.get(1).getId());
        wpdchest.setEx3(chest.get(2).getId());
        wpdchest.setEx4(chest.get(3).getId());
        wpdchest.setEx5(chest.get(4).getId());
        wpdchest.setEx6(chest.get(5).getId());
        wpdchest.setTypeOfPlan(6);
        wpdchest.setJoinThisPlan(actualIndex);

        workoutPlanDayRepository.save(wpdchest);

        WorkoutPlanDay wpdback = new WorkoutPlanDay();
        wpdback.setEx1(back.get(0).getId());
        wpdback.setEx2(back.get(1).getId());
        wpdback.setEx3(back.get(2).getId());
        wpdback.setEx4(back.get(3).getId());
        wpdback.setEx5(back.get(4).getId());
        wpdback.setEx6(back.get(5).getId());
        wpdback.setTypeOfPlan(7);
        wpdback.setJoinThisPlan(actualIndex);

        workoutPlanDayRepository.save(wpdback);

        WorkoutPlanDay wpdshoulders = new WorkoutPlanDay();
        wpdshoulders.setEx1(fshoulder.get(0).getId());
        wpdshoulders.setEx2(fshoulder.get(1).getId());
        wpdshoulders.setEx3(sshoulder.get(0).getId());
        wpdshoulders.setEx4(sshoulder.get(1).getId());
        wpdshoulders.setEx5(rshoulder.get(0).getId());
        wpdshoulders.setEx6(rshoulder.get(1).getId());
        wpdshoulders.setTypeOfPlan(8);
        wpdshoulders.setJoinThisPlan(actualIndex);

        workoutPlanDayRepository.save(wpdshoulders);

        WorkoutPlanDay wpdsarms = new WorkoutPlanDay();
        wpdsarms.setEx1(biceps.get(0).getId());
        wpdsarms.setEx2(biceps.get(1).getId());
        wpdsarms.setEx3(biceps.get(2).getId());
        wpdsarms.setEx4(triceps.get(0).getId());
        wpdsarms.setEx5(triceps.get(1).getId());
        wpdsarms.setEx6(triceps.get(2).getId());
        wpdsarms.setTypeOfPlan(9);
        wpdsarms.setJoinThisPlan(actualIndex);

        workoutPlanDayRepository.save(wpdsarms);

        addLeg(actualIndex, 9,4,1,2,10);

        return "Workout plan Bro Split is ready!";
    }
    public String addPlan(int actualIndex, int prio1id, int prio1limit, int prio2id, int prio2limit, int prio3id, int prio3limit, int typeOfPlan){

        List<Exercise> prio1= exerciseRepository.addAllExercise(Collections.singleton(prio1id), Collections.singleton(prio1limit));
        List<Exercise> prio2 = exerciseRepository.addAllExercise(Collections.singleton(prio2id), Collections.singleton(prio2limit));
        List<Exercise> prio3= exerciseRepository.addAllExercise(Collections.singleton(prio3id), Collections.singleton(prio3limit));

        WorkoutPlanDay workoutPlanDay = new WorkoutPlanDay();
        workoutPlanDay.setEx1(prio1.get(0).getId());
        workoutPlanDay.setEx2(prio1.get(1).getId());
        workoutPlanDay.setEx3(prio1.get(2).getId());
        workoutPlanDay.setEx4(prio2.get(0).getId());
        workoutPlanDay.setEx5(prio3.get(0).getId());
        workoutPlanDay.setEx6(prio3.get(1).getId());
        workoutPlanDay.setTypeOfPlan(typeOfPlan);
        workoutPlanDay.setJoinThisPlan(actualIndex);

        workoutPlanDayRepository.save(workoutPlanDay);

        return "Workoutplan is ready!";
    }
    public String addLeg(int actualIndex, int prio1id, int prio1limit, int prio2id, int prio2limit, int typeOfPlan){

        List<Exercise> leg= exerciseRepository.addAllExercise(Collections.singleton(prio1id), Collections.singleton(prio1limit));
        List<Exercise> culve = exerciseRepository.addAllExercise(Collections.singleton(prio2id), Collections.singleton(prio2limit));

        WorkoutPlanDay wpdleg = new WorkoutPlanDay();
        wpdleg.setEx1(leg.get(0).getId());
        wpdleg.setEx2(leg.get(1).getId());
        wpdleg.setEx3(leg.get(2).getId());
        wpdleg.setEx4(leg.get(3).getId());
        wpdleg.setEx5(culve.get(0).getId());
        wpdleg.setEx6(culve.get(1).getId());
        wpdleg.setTypeOfPlan(typeOfPlan);
        wpdleg.setJoinThisPlan(actualIndex);

        workoutPlanDayRepository.save(wpdleg);

        return "Workoutplan is ready!";
    }
}

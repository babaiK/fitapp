package com.fittapp.repository;

import com.fittapp.model.Exercise;
import com.fittapp.model.WorkoutView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface WorkoutViewRepository extends JpaRepository<WorkoutView, Long>{

    @Query(value = "select wvr.id, wvr.exercise1, wvr.exercise2," +
            " wvr.exercise3, wvr.exercise4, wvr.exercise5, " +
            " wvr.exercise6, wvr.join_this_plan, wvr.type_of_plan" +
            " from WorkoutView wvr where wvr.join_this_plan = :whichPlan",
            nativeQuery = true)
    List<WorkoutView> addWorkoutView(@Param("whichPlan") Collection<Integer> whichPlan);


//    @Query(value = "select e.id, e.name, e.muscle_Group_Id from Exercise e " +
//            "inner join Muscle_Group mg on e.muscle_Group_Id = mg.id " +
//            "where mg.id = :muscle " +
//            "order by random() limit :limit",
//            nativeQuery = true)
//    List<Exercise>addAllExercise(@Param("muscle")Collection<Integer>muscle,
//                                 @Param("limit")Collection<Integer>limit);
}

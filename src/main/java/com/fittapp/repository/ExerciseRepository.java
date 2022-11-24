package com.fittapp.repository;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.fittapp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    @Query(value = "select join_this_plan from Workout_Plan_day wpd order by join_this_plan desc limit 1", nativeQuery = true)
    Integer lastIndex();

    @Query(value = "select e.id, e.name, e.muscle_Group_Id from Exercise e " +
            "inner join Muscle_Group mg on e.muscle_Group_Id = mg.id " +
            "where mg.id = :muscle " +
            "order by random() limit :limit",
            nativeQuery = true)
    List<Exercise>addAllExercise(@Param("muscle")Collection<Integer>muscle,
                                @Param("limit")Collection<Integer>limit);

}

package com.fittapp.repository;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.fittapp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    @Query(value = "select e.id, e.name, e.muscle_Group_Id from Exercise e inner join Muscle_Group mg on e.muscle_Group_Id = mg.id where mg.ppl = 1",
            nativeQuery = true)
    //Exercise allPush();
    List<Exercise> allPush();

}

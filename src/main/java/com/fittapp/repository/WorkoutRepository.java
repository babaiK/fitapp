package com.fittapp.repository;

import com.fittapp.model.Exercise;
import com.fittapp.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

//    @Query(value="SELECT * FROM Exercise e WHERE muscle_group_id='2' ORDER BY random() limit 1", nativeQuery = true)
//    Exercise randomChest();

}

package com.fittapp.repository;

import com.fittapp.model.Exercise;
import com.fittapp.model.WorkoutPlanDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface WorkoutPlanDayRepository extends JpaRepository<WorkoutPlanDay, Long> {

}

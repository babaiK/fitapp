package com.fittapp.repository;

import com.fittapp.model.Exercise;
import com.fittapp.model.MuscleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {

}

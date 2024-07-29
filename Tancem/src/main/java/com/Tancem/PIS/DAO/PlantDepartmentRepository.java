package com.Tancem.PIS.DAO;

import com.Tancem.PIS.Model.PlantDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantDepartmentRepository extends JpaRepository<PlantDepartment, Integer> {
}


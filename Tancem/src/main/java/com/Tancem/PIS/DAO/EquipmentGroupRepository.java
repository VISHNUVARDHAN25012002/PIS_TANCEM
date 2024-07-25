package com.Tancem.PIS.DAO;


import com.Tancem.PIS.Model.EquipmentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentGroupRepository extends JpaRepository<EquipmentGroup, Integer> {
}


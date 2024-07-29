package com.Tancem.PIS.DAO;

import com.Tancem.PIS.Model.SubEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubEquipmentRepository extends JpaRepository<SubEquipment, Integer> {
}


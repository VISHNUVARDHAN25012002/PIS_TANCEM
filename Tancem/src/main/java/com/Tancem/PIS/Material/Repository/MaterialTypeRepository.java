package com.Tancem.PIS.Material.Repository;


import com.Tancem.PIS.Model.Material_Type.Material_Type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialTypeRepository extends JpaRepository<Material_Type, Integer> {
}

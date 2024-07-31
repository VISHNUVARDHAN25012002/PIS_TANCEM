package com.Tancem.PIS.DAO.Material_Repository;

import com.Tancem.PIS.Model.Material.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

}

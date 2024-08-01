package com.Tancem.PIS.Material.Repository;

import com.Tancem.PIS.Material.Entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer> {

}

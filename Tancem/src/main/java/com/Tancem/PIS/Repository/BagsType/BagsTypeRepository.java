package com.Tancem.PIS.Repository.BagsType;

import com.Tancem.PIS.Model.BagsType.BagsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface BagsTypeRepository extends JpaRepository<BagsType, Integer> {
}

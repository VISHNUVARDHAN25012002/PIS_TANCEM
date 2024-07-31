package com.Tancem.PIS.DAO.Source_Repository;

import com.Tancem.PIS.Model.Source.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source, Integer> {
}

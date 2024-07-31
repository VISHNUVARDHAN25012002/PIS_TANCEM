package com.Tancem.PIS.DAO.Status_Repository;

import com.Tancem.PIS.Model.Status.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Integer> {

}

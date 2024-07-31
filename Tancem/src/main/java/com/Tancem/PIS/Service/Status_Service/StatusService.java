package com.Tancem.PIS.Service.Status_Service;

import com.Tancem.PIS.Model.Status.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatusService {
    List<Status> getAllStatuses();
    Status getStatusById(Integer id);
    Status saveStatus(Status status);
    void deleteStatus(Integer id);
}

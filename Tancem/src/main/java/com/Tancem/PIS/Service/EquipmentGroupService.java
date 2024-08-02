package com.Tancem.PIS.Service;


import com.Tancem.PIS.Model.EquipmentGroup;

import java.util.List;

public interface EquipmentGroupService {
    List<EquipmentGroup> findAll();
    EquipmentGroup findById(Integer id);
    EquipmentGroup save(EquipmentGroup equipmentGroup);
    void deactivate(Integer id);
    void activate(Integer id);
}



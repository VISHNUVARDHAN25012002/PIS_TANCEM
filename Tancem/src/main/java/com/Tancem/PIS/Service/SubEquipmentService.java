package com.Tancem.PIS.Service;


import com.Tancem.PIS.Model.SubEquipment;

import java.util.List;

public interface SubEquipmentService {
    List<SubEquipment> getAllSubEquipments();
    SubEquipment getSubEquipmentById(Integer id);
    SubEquipment saveSubEquipment(SubEquipment subEquipment);
    void deleteSubEquipment(Integer id);
}


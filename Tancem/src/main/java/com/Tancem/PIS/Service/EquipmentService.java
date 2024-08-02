package com.Tancem.PIS.Service;

import com.Tancem.PIS.Model.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAllEquipments();

    Equipment getEquipmentById(Integer id);

    Equipment saveEquipment(Equipment equipment);

    void deactivateEquipment(Integer id);

    void activateEquipment(Integer id);

}
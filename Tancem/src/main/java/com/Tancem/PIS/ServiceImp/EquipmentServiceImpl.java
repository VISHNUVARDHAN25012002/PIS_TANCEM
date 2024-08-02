package com.Tancem.PIS.ServiceImp;

import com.Tancem.PIS.DAO.EquipmentRepository;
import com.Tancem.PIS.Model.Equipment;
import com.Tancem.PIS.Service.EquipmentService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentServiceImpl.class);


    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getAllEquipments() {
        logger.info("Fetching all equipments");
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment getEquipmentById(Integer id) {
        logger.info("Fetching equipment with id: {}", id);
        return equipmentRepository.findById(id).orElse(null);
    }

    @Override
    public Equipment saveEquipment(Equipment equipment) {
        if (equipment.getId() == null) {
            equipment.setCreated_At(LocalDateTime.now());
        } else {
            equipment.setUpdated_At(LocalDateTime.now());
        }
        logger.info("Saving equipment: {}", equipment);
        return equipmentRepository.save(equipment);
    }

    @Override
    public void deactivateEquipment(Integer id) {
        Equipment equipment = getEquipmentById(id);
        if (equipment != null) {
            logger.info("Deactivating equipment with ID: {}", id);
            equipment.setActive(false);
            equipmentRepository.save(equipment);
        } else {
            logger.warn("Equipment with ID: {} not found, cannot deactivate", id);
        }
    }

    @Override
    public void activateEquipment(Integer id) {
        Equipment equipment = getEquipmentById(id);
        if (equipment != null) {
            logger.info("Activating equipment with ID: {}", id);
            equipment.setActive(true);
            equipmentRepository.save(equipment);
        } else {
            logger.warn("Equipment with ID: {} not found, cannot activate", id);
        }
    }
}
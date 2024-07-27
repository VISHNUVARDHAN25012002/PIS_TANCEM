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
            equipment.setCreatedAt(LocalDateTime.now());
        } else {
            equipment.setUpdatedAt(LocalDateTime.now());
        }
        logger.info("Saving equipment: {}", equipment);
        return equipmentRepository.save(equipment);
    }

    @Override
    public void deleteEquipment(Integer id) {
        logger.info("Deleting equipment with id: {}", id);
        if (equipmentRepository.existsById(id)) {
            equipmentRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Equipment not found with id: " + id);
        }
    }
}
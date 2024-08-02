package com.Tancem.PIS.ServiceImp;


import com.Tancem.PIS.DAO.SubEquipmentRepository;
import com.Tancem.PIS.Model.SubEquipment;
import com.Tancem.PIS.Service.SubEquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubEquipmentServiceImpl implements SubEquipmentService {
    private static final Logger logger = LoggerFactory.getLogger(SubEquipmentServiceImpl.class);


    @Autowired
    private SubEquipmentRepository subEquipmentRepository;

    @Override
    public List<SubEquipment> getAllSubEquipments() {
        logger.info("Fetching all sub-equipments");
        return subEquipmentRepository.findAll();
    }

    @Override
    public SubEquipment getSubEquipmentById(Integer id) {
        logger.info("Fetching sub-equipment with id: {}", id);
        return subEquipmentRepository.findById(id).orElse(null);
    }

    @Override
    public SubEquipment saveSubEquipment(SubEquipment subEquipment) {
        if (subEquipment.getId() == 0) {
            subEquipment.setCreated_At(LocalDateTime.now());
        } else {
            subEquipment.setUpdated_At(LocalDateTime.now());
        }
        logger.info("Saving sub-equipment: {}", subEquipment);
        return subEquipmentRepository.save(subEquipment);
    }


    @Override
    public void deactivateSubEquipment(Integer id) {
        SubEquipment subEquipment = getSubEquipmentById(id);
        if (subEquipment != null) {
            subEquipment.setActive(false);
            subEquipment.setUpdated_At(LocalDateTime.now());
            subEquipmentRepository.save(subEquipment);
            logger.info("Deactivated sub-equipment with id: {}", id);
        } else {
            logger.warn("Sub-equipment with id: {} not found for deactivation", id);
        }
    }

    @Override
    public void activateSubEquipment(Integer id) {
        SubEquipment subEquipment = getSubEquipmentById(id);
        if (subEquipment != null) {
            subEquipment.setActive(true);
            subEquipment.setUpdated_At(LocalDateTime.now());
            subEquipmentRepository.save(subEquipment);
            logger.info("Activated sub-equipment with id: {}", id);
        } else {
            logger.warn("Sub-equipment with id: {} not found for activation", id);
        }
    }
}
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
        if (subEquipment.getId() == null) {
            subEquipment.setCreatedAt(LocalDateTime.now());
        } else {
            subEquipment.setUpdatedAt(LocalDateTime.now());
        }
        logger.info("Saving sub-equipment: {}", subEquipment);
        return subEquipmentRepository.save(subEquipment);
    }

    @Override
    public void deleteSubEquipment(Integer id) {
        logger.info("Deleting sub-equipment with id: {}", id);
        subEquipmentRepository.deleteById(id);
    }
}
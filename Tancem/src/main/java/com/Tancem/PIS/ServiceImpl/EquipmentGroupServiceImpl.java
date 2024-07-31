package com.Tancem.PIS.ServiceImpl;

import com.Tancem.PIS.DAO.EquipmentGroupRepository;
import com.Tancem.PIS.Model.EquipmentGroup;
import com.Tancem.PIS.Service.EquipmentGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EquipmentGroupServiceImpl implements EquipmentGroupService {
    private static final Logger logger = LoggerFactory.getLogger(EquipmentGroupServiceImpl.class);

    @Autowired
    private EquipmentGroupRepository repository;

    @Override
    public List<EquipmentGroup> findAll() {
        logger.info("Fetching all equipment groups");
        return repository.findAll();
    }

    @Override
    public EquipmentGroup findById(Integer id) {
        logger.info("Fetching equipment group with id: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public EquipmentGroup save(EquipmentGroup equipmentGroup) {
        if (equipmentGroup.getId() == null) {
            equipmentGroup.setCreatedAt(LocalDateTime.now());
        } else {
            equipmentGroup.setUpdatedAt(LocalDateTime.now());
        }
        logger.info("Saving equipment group: {}", equipmentGroup);
        return repository.save(equipmentGroup);
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("Deleting equipment group with id: {}", id);
        repository.deleteById(id);
    }
}


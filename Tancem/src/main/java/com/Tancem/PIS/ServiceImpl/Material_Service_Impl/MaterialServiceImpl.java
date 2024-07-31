package com.Tancem.PIS.ServiceImpl.Material_Service_Impl;

import com.Tancem.PIS.DAO.Material_Repository.MaterialRepository;

import com.Tancem.PIS.Exceptions.CustomException;
import com.Tancem.PIS.Model.Material.Material;
import com.Tancem.PIS.Service.Material_Service.MaterialService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {
 private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);



    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<Material> getAllMaterials() {
        try {
            return materialRepository.findAll();
        } catch (Exception e) {
            logger.error("Error retrieving materials", e);
            throw new CustomException("Error retrieving materials");
        }
    }

    @Override
    public Material getMaterialById(Integer id) {
        try {
            return materialRepository.findById(id).orElseThrow(() -> new CustomException("Material not found"));
        } catch (Exception e) {
            logger.error("Error retrieving material with id: {}", id, e);
            throw new CustomException("Error retrieving material");
        }
    }

    @Override
    public Material saveMaterial(Material material) {
        try {
            return materialRepository.save(material);
        } catch (Exception e) {
            logger.error("Error saving material", e);
            throw new CustomException("Error saving material");
        }
    }

    @Override
    public void deleteMaterial(Integer id) {
        try {
            materialRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error deleting material with id: {}", id, e);
            throw new CustomException("Error deleting material");
        }
    }
}
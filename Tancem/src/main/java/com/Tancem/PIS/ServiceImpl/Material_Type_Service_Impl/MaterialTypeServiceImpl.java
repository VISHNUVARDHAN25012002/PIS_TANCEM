package com.Tancem.PIS.ServiceImpl.Material_Type_Service_Impl;

import com.Tancem.PIS.Material.Repository.MaterialTypeRepository;
import com.Tancem.PIS.Exceptions.CustomException;

import com.Tancem.PIS.Model.Material_Type.Material_Type;

import com.Tancem.PIS.Service.Material_Type_Service.MaterialTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialTypeServiceImpl implements MaterialTypeService {
    private static final Logger logger = LoggerFactory.getLogger(MaterialTypeServiceImpl.class);

    @Autowired
    private MaterialTypeRepository materialTypeRepository;

    @Override
    public List<Material_Type> getAllMaterialTypes() {
        List<Material_Type> materialTypes = materialTypeRepository.findAll();
        logger.info("Retrieved all material types");
        return materialTypes;
    }

    @Override
    public Material_Type getMaterialTypeById(Integer id) {
        Optional<Material_Type> materialType = materialTypeRepository.findById(id);
        if (materialType.isPresent()) {
            logger.info("Retrieved material type with id: {}", id);
            return materialType.get();
        } else {
            logger.error("MaterialType not found with id: {}", id);
            throw new CustomException("MaterialType not found");
        }
    }

    @Override
    public Material_Type saveMaterialType(Material_Type materialType) {
        Material_Type savedMaterialType = materialTypeRepository.save(materialType);
        logger.info("Saved material type with id: {}", savedMaterialType.getId());
        return savedMaterialType;
    }

    @Override
    public void deleteMaterialType(Integer id) {
        materialTypeRepository.deleteById(id);
        logger.info("Deleted material type with id: {}", id);
    }
}

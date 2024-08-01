package com.Tancem.PIS.ServiceImp.BagsType;

import com.Tancem.PIS.Exceptions.ResourceNotFoundException;
import com.Tancem.PIS.Model.BagsType.BagsType;
import com.Tancem.PIS.Repository.BagsType.BagsTypeRepository;
import com.Tancem.PIS.Service.BagsType.BagsTypeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BagsTypeServiceImp implements BagsTypeService {
    private static final Logger logger = LoggerFactory.getLogger(BagsTypeServiceImp.class);

    @Autowired
    private BagsTypeRepository bagsTypeRepository;

    @Override
    public List<BagsType> getAllBagTypes() {
        logger.info("Fetching all bag types.");
        return bagsTypeRepository.findAll();
    }

    @Override
    public BagsType getBagTypeById(int id) {
        logger.info("Fetching bag type with id: {}", id);
//        return bagsTypeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Bag type not found with id: " + id));
//
          return bagsTypeRepository.findById(id).orElse(null); }

    @Override
    public BagsType saveBagType(BagsType bagType) {
        logger.info("Saving new bag type.");
        bagsTypeRepository.save(bagType);
        return bagType;
    }

    @Override
    public void updateBagType(int id, BagsType bagType) {
        logger.info("Updating bag type with id: {}", id);
        BagsType existingBagType = bagsTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bag type not found with id: " + id));

        existingBagType.setTypes_Of_Bags(bagType.getTypes_Of_Bags());
        existingBagType.setCreated_At(bagType.getCreated_At());
        existingBagType.setUpdated_At(bagType.getUpdated_At());

        bagsTypeRepository.save(existingBagType);
    }

    @Override
    public void deleteBagType(int id) {
        logger.info("Deleting bag type with id: {}", id);
        BagsType existingBagType = bagsTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bag type not found with id: " + id));
        bagsTypeRepository.delete(existingBagType);
    }



}

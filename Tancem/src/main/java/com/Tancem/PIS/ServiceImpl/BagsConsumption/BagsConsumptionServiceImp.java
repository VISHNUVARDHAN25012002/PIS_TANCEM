package com.Tancem.PIS.ServiceImpl.BagsConsumption;

import com.Tancem.PIS.Exceptions.ResourceNotFoundException;
import com.Tancem.PIS.Model.BagsConsumption.BagsConsumption;
import com.Tancem.PIS.Repository.BagsConsumption.BagsConsumptionRepository;
import com.Tancem.PIS.Service.BagsConsumption.BagsConsumptionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BagsConsumptionServiceImp implements BagsConsumptionService {
    private static final Logger logger = LoggerFactory.getLogger(BagsConsumptionServiceImp.class);
    //had to import it from Slf4j


    @Autowired
    private BagsConsumptionRepository bagsConsumptionRepository;

    @Override
    public List<BagsConsumption> getAllBags() {
        logger.info("Fetching all bags.");
        return bagsConsumptionRepository.findAll();
    }

    @Override
    public BagsConsumption getBagById(int id) {
        logger.info("Fetching bag with id: {}", id);
//        return bagsConsumptionRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Bag not found with id: " + id));
//
         return bagsConsumptionRepository.findById(id).orElse(null); }

    @Override
    public BagsConsumption saveBag(BagsConsumption bag) {
        logger.info("Saving new bag.");
        bagsConsumptionRepository.save(bag);
        return bag;
    }

    @Override
    public BagsConsumption updateBag(int id, BagsConsumption bag) {
        logger.info("Updating bag with id: {}", id);
        BagsConsumption existingBag = bagsConsumptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bag not found with id: " + id));

        existingBag.setTransaction_Date(bag.getTransaction_Date());
        existingBag.setOpc_Bags(bag.getOpc_Bags());
        existingBag.setPpc_Bags(bag.getPpc_Bags());
        existingBag.setSrc_Bag(bag.getSrc_Bag());
        existingBag.setNo_Of_Export_Bag(bag.getNo_Of_Export_Bag());
        existingBag.setNo_Of_Depot_Bags(bag.getNo_Of_Depot_Bags());
        existingBag.setNo_Of_Brust_Opc_Bags(bag.getNo_Of_Brust_Opc_Bags());
        existingBag.setNo_Of_Brust_Ppc_Bags(bag.getNo_Of_Brust_Ppc_Bags());
        existingBag.setNo_Of_Brust_Src_Bags(bag.getNo_Of_Brust_Src_Bags());
        existingBag.setTransfer_To_Other_Plants(bag.getTransfer_To_Other_Plants());
        existingBag.setBagsType(bag.getBagsType());

        bagsConsumptionRepository.save(existingBag);
        return existingBag;
    }

    @Override
    public boolean deleteBag(int id) {
        logger.info("Deleting bag with id: {}", id);
        BagsConsumption existingBag = bagsConsumptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bag not found with id: " + id));
        bagsConsumptionRepository.delete(existingBag);
        return false;
    }


}

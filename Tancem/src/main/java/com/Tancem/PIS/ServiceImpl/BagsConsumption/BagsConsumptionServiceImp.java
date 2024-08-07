package com.Tancem.PIS.ServiceImpl.BagsConsumption;

import com.Tancem.PIS.Exceptions.ResourceNotFoundException;
import com.Tancem.PIS.Model.BagsConsumption;
import com.Tancem.PIS.Repository.BagsConsumption.BagsConsumptionRepository;
import com.Tancem.PIS.Service.BagsConsumption.BagsConsumptionService;
import com.Tancem.PIS.Service.logService.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BagsConsumptionServiceImp implements BagsConsumptionService {

    @Autowired
    private BagsConsumptionRepository bagsConsumptionRepository;

    @Autowired
    private LogService logService;

    @Override
    public List<BagsConsumption> getAllBags() {
        logService.logDbOperation("Fetching all bags.");
        return bagsConsumptionRepository.findAll();
    }

    @Override
    public BagsConsumption getBagById(int id) {
        logService.logDbOperation("Fetching bag with ID: " + id);
        return bagsConsumptionRepository.findById(id).orElse(null);
    }

    @Override
    public BagsConsumption saveBag(BagsConsumption bag) {
        BagsConsumption savedBag = bagsConsumptionRepository.save(bag);
        logService.logDbOperation("Saved bag with ID: " + savedBag.getId());
        return savedBag;
    }

    @Override
    public BagsConsumption updateBag(int id, BagsConsumption bag) {
        logService.logDbOperation("Updating bag with ID: " + id);
        BagsConsumption existingBag = bagsConsumptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bag not found with ID: " + id));

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

        BagsConsumption updatedBag = bagsConsumptionRepository.save(existingBag);
        logService.logDbOperation("Updated bag with ID: " + updatedBag.getId());
        return updatedBag;
    }

    @Override
    public boolean deleteBag(int id) {
        logService.logDbOperation("Deleting bag with ID: " + id);
        BagsConsumption existingBag = bagsConsumptionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bag not found with ID: " + id));
        bagsConsumptionRepository.delete(existingBag);
        logService.logDbOperation("Deleted bag with ID: " + id);
        return true;
    }
}

package com.Tancem.PIS.Service.BagsConsumption;

import com.Tancem.PIS.Model.BagsConsumption;

import java.util.List;

public interface BagsConsumptionService {
    List<BagsConsumption> getAllBags();
    BagsConsumption getBagById(int id);
    BagsConsumption saveBag(BagsConsumption bag);
    BagsConsumption updateBag(int id, BagsConsumption bag);
    boolean deleteBag(int id);
}

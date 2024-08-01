package com.Tancem.PIS.Service.BagsType;

import com.Tancem.PIS.Model.BagsType;

import java.util.List;

public interface BagsTypeService {
    List<BagsType> getAllBagTypes();
    BagsType getBagTypeById(int id);
    BagsType saveBagType(BagsType bagType);
    void updateBagType(int id, BagsType bagType);
    void deleteBagType(int id);
}

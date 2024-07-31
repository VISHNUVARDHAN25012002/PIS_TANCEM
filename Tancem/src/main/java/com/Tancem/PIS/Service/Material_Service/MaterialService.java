package com.Tancem.PIS.Service.Material_Service;

import com.Tancem.PIS.Model.Material.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getAllMaterials();
    Material getMaterialById(Integer id);
    Material saveMaterial(Material material);
    void deleteMaterial(Integer id);
}
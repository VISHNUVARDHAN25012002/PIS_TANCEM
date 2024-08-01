package com.Tancem.PIS.Material.Service;

import com.Tancem.PIS.Material.Entity.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getAllMaterials();
    Material getMaterialById(Integer id);
    Material saveMaterial(Material material);
    void deleteMaterial(Integer id);
}
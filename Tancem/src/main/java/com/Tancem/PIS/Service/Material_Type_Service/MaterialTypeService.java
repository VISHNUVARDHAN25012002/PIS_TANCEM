package com.Tancem.PIS.Service.Material_Type_Service;


import com.Tancem.PIS.Model.Material_Type.Material_Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MaterialTypeService {
    List<Material_Type> getAllMaterialTypes();
    Material_Type getMaterialTypeById(Integer id);
    Material_Type saveMaterialType(Material_Type materialType);

    //Material_Type saveMaterialType(Material_Type materialType);

    void deleteMaterialType(Integer id);
}

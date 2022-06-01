package com.ecommerce.app.service;

import com.ecommerce.app.service.dto.BrandDTO;

import java.util.List;

public interface BrandService {

    BrandDTO create(BrandDTO brand);
    BrandDTO update(long id, BrandDTO brand);
    void delete(long id);
    BrandDTO get(long id);
    List<BrandDTO> findAll();
}

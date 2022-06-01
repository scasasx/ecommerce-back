package com.ecommerce.app.service.impl;


import com.ecommerce.app.exceptions.ResourceNotFoundException;
import com.ecommerce.app.model.Brand;
import com.ecommerce.app.repository.BrandRepository;
import com.ecommerce.app.service.BrandService;
import com.ecommerce.app.service.dto.BrandDTO;
import com.ecommerce.app.service.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    BrandRepository brandRepository;

    @Override
    public BrandDTO create(BrandDTO brand) {
        return brandMapper.toDto(brandRepository.save(brandMapper.toEntity(brand)));
    }

    @Override
    public BrandDTO update(long id, BrandDTO brandDetails) {
        Brand updatebrand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not exist with id: " + id));

        updatebrand.setName(brandDetails.getName());
        Brand brand = brandRepository.save(brandMapper.toEntity(brandDetails));

        return brandMapper.toDto(brand);

    }

    @Override
    public void delete(long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not exist with id: " + id));

        brandRepository.delete(brand);
    }

    @Override
    public BrandDTO get(long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Brand not exist with id:" + id));

        return brandMapper.toDto(brand);
    }

    @Override
    public List<BrandDTO> findAll() {
        return brandMapper.toDto(brandRepository.findAll());
    }
}

package com.ecommerce.app.service.impl;


import com.ecommerce.app.controller.request.SearchDTO;
import com.ecommerce.app.exceptions.ResourceNotFoundException;
import com.ecommerce.app.model.Price;
import com.ecommerce.app.repository.PriceRepository;
import com.ecommerce.app.service.PriceService;
import com.ecommerce.app.service.dto.PriceDTO;
import com.ecommerce.app.service.mapper.PriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceMapper priceMapper;

    @Autowired
    PriceRepository priceRepository;

    @Override
    public PriceDTO create(PriceDTO priceDTO) {
        Price price = priceMapper.toEntity(priceDTO);
        return priceMapper.toDto(priceRepository.save(price));
    }

    @Override
    public PriceDTO update(long id, PriceDTO priceDetails) {
        Price updatePrice = priceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Price not exist with id: " + id));

        Price price = priceRepository.save(priceMapper.toEntity(priceDetails));

        return priceMapper.toDto(price);
    }

    @Override
    public void delete(long id) {
        Price price = priceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Price not exist with id: " + id));

        priceRepository.delete(price);
    }

    @Override
    public PriceDTO get(long id) {
        Price price = priceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Price not exist with id:" + id));

        return priceMapper.toDto(price);
    }

    @Override
    public List<PriceDTO> findAll() {

        return priceMapper.toDto(priceRepository.findAll());
    }

    @Override
    public PriceDTO search(SearchDTO search) {
        List<Price> prices = priceRepository.search(search.getBrandId(),search.getProductId(),search.getDate())
                .orElseThrow(() -> new ResourceNotFoundException("Price not exist for this search"));

        if (prices.size()>0){
            Price price = Collections.max(prices, Comparator.comparing(p -> p.getPriority()));
            return priceMapper.toDto(price);
        }

        throw  new ResourceNotFoundException("Price not exist for this search");
    }
    
}

package com.ecommerce.app.service;

import com.ecommerce.app.controller.request.SearchDTO;
import com.ecommerce.app.service.dto.PriceDTO;

import java.util.List;

public interface PriceService {

    PriceDTO create(PriceDTO price);
    PriceDTO update(long id, PriceDTO price);
    void delete(long id);
    PriceDTO get(long id);
    List<PriceDTO> findAll();
    PriceDTO search(SearchDTO search);
}

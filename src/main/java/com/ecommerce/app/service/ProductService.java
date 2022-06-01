package com.ecommerce.app.service;

import com.ecommerce.app.service.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO create(ProductDTO product);
    ProductDTO update(long id, ProductDTO product);
    void delete(long id);
    ProductDTO get(long id);
    List<ProductDTO> findAll();
}

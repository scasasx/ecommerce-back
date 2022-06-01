package com.ecommerce.app.service.impl;


import com.ecommerce.app.exceptions.ResourceNotFoundException;
import com.ecommerce.app.model.Product;
import com.ecommerce.app.repository.ProductRepository;
import com.ecommerce.app.service.ProductService;
import com.ecommerce.app.service.dto.ProductDTO;
import com.ecommerce.app.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDTO create(ProductDTO product) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(product)));
    }

    @Override
    public ProductDTO update(long id, ProductDTO productDetails) {
        Product updateproduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));

        updateproduct.setName(productDetails.getName());
        Product product = productRepository.save(productMapper.toEntity(productDetails));

        return productMapper.toDto(product);

    }

    @Override
    public void delete(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));

        productRepository.delete(product);
    }

    @Override
    public ProductDTO get(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id:" + id));

        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productMapper.toDto(productRepository.findAll());
    }
}

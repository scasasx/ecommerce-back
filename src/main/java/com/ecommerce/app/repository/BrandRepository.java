package com.ecommerce.app.repository;

import com.ecommerce.app.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, Long> {
    // all crud database methods
}
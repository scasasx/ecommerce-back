package com.ecommerce.app.repository;

import com.ecommerce.app.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface PriceRepository extends JpaRepository<Price, Long> {
    // all crud database methods

    @Query("SELECT p FROM Price p  WHERE p.brand.id = ?1 and p.product.id = ?2 and ( ?3 BETWEEN p.startDate AND p.endDate)")
    Optional<List<Price>> search(long brandId, long productId, LocalDateTime date);

}
package com.urbanbazaar.Repo;

import com.urbanbazaar.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM product WHERE type = :type", nativeQuery = true)
    //@Query("SELECT u FROM product u WHERE u.type = :type") --> not working here but this prevents sql injection
    List<Product> findByCategory(@Param("type") String category);
}

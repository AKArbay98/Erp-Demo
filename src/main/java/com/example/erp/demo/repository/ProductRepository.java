package com.example.erp.demo.repository;

import com.example.erp.demo.model.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}

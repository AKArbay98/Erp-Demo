package com.example.erp.demo.repository;

import com.example.erp.demo.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends  JpaRepository<License,String> {
}

package com.example.erp.demo.repository;

import com.example.erp.demo.model.entity.license.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LicenseRepository extends  JpaRepository<License,Long> {

    Optional<License> findByLicenseKey(String licenseKey);
}

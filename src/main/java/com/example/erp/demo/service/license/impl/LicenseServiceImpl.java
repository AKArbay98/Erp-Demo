package com.example.erp.demo.service.license.impl;

import com.example.erp.demo.model.entity.license.License;
import com.example.erp.demo.model.enumeration.LicenseStatus;
import com.example.erp.demo.repository.LicenseRepository;
import com.example.erp.demo.service.license.LicenseService;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

@Service
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository licenseRepository;
    private static final int PRIME_CERTAINTY = 100;

    public LicenseServiceImpl(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @Override
    public boolean isValidLicenseKey(String licenseKey) {
        License license = licenseRepository.findByLicenseKey(licenseKey).orElse(null);
        if(license == null){
            return  false;
        }
        return license.getLicenseStatus() == LicenseStatus.ACTIVE &&
                LocalDate.now().isBefore(license.getEndDate()) &&
                LocalDate.now().isAfter(license.getStartDate());
    }

    @Override
    public String createLicenseKey(Long customerId, Long productId) {
//        primeBase → hash → hexString
        BigInteger base = calculatePrimeBase(customerId, productId);
        byte[] hash = sha256Hash(base);
        return toHex(hash);
    }

    private BigInteger generateDeterministicPrime(Long seed){
        BigInteger candidate = BigInteger.valueOf(seed);
        while(!candidate.isProbablePrime(PRIME_CERTAINTY)){
            candidate = candidate.add(BigInteger.ONE);
        }
        return candidate;
    }

    private BigInteger calculatePrimeBase(Long customerId, Long productId){
        BigInteger primeOne = generateDeterministicPrime(customerId);
        BigInteger primeTwo = generateDeterministicPrime(productId);
        return primeOne.multiply(primeTwo);
    }

    private byte[] sha256Hash(BigInteger input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(input.toByteArray());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 not supported", e);
        }
    }

    private String toHex(byte[] bytes){
        return DatatypeConverter.printHexBinary(bytes);
    }

}

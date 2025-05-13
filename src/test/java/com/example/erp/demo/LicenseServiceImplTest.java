package com.example.erp.demo;


import com.example.erp.demo.model.entity.license.License;
import com.example.erp.demo.model.enumeration.LicenseStatus;
import com.example.erp.demo.repository.LicenseRepository;
import com.example.erp.demo.service.license.impl.LicenseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class LicenseServiceImplTest {

    @Mock
    private LicenseRepository licenseRepository;

    @InjectMocks
    private LicenseServiceImpl licenseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testIsValidLicenseKey_ValidLicense() {
        String licenseKey = "VALID_KEY";
        License license = new License();
        license.setLicenseKey(licenseKey);
        license.setLicenseStatus(LicenseStatus.ACTIVE);
        license.setStartDate(LocalDate.now().minusDays(1));
        license.setEndDate(LocalDate.now().plusDays(1));

        when(licenseRepository.findByLicenseKey(licenseKey)).thenReturn(Optional.of(license));

        boolean isValid = licenseService.isValidLicenseKey(licenseKey);

        assertTrue(isValid);
        verify(licenseRepository, times(1)).findByLicenseKey(licenseKey);
    }

    @Test
    public void testIsValidLicenseKey_InvalidLicense() {
        String licenseKey = "INVALID_KEY";

        when(licenseRepository.findByLicenseKey(licenseKey)).thenReturn(Optional.empty());

        boolean isValid = licenseService.isValidLicenseKey(licenseKey);

        assertFalse(isValid);
        verify(licenseRepository, times(1)).findByLicenseKey(licenseKey);
    }

    @Test
    public void testCreateLicenseKey() {
        Long customerId = 567L;
        Long productId = 789L;

        String licenseKey = licenseService.createLicenseKey(customerId, productId);

        assertNotNull(licenseKey);
        assertFalse(licenseKey.isEmpty());
    }
}

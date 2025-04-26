package com.example.UberReviewService.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    Optional<Driver> findByIdAndLicenseNumber(Long id,String licenseNumber);

    @Query(nativeQuery = true,value="SELECT * FROM Driver WHERE id=:id AND license_number=:license")
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id,String license);

    @Query("SELECT d from Driver d where d.id=:id AND d.licenseNumber=:ln")
    Optional<Driver> hqlFindByIdAndLicense(Long id,String ln);
}

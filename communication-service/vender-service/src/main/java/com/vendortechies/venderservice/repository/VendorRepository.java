package com.vendortechies.venderservice.repository;

import com.vendortechies.venderservice.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {
}

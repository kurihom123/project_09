package com.vendortechies.venderservice.service;

import com.vendortechies.venderservice.dto.ResponseDto;
import com.vendortechies.venderservice.model.Vendor;

public interface VendorService {
    Vendor saveVendor(Vendor vendor);
    ResponseDto getVendor(int vendorId);
}

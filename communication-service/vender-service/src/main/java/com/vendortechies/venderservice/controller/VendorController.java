package com.vendortechies.venderservice.controller;

import com.vendortechies.venderservice.dto.ResponseDto;
import com.vendortechies.venderservice.model.Vendor;
import com.vendortechies.venderservice.service.VendorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vendors")
@AllArgsConstructor
public class VendorController {
    private final VendorService vendorService;

    @PostMapping
    public ResponseEntity<Vendor> saveVendor(@RequestBody Vendor vendor){
        Vendor savedVendor = vendorService.saveVendor(vendor);
        return new ResponseEntity<>(savedVendor, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getVendor(@PathVariable("id") int vendorId){
        ResponseDto responseDto = vendorService.getVendor(vendorId);
        return ResponseEntity.ok(responseDto);
    }
}

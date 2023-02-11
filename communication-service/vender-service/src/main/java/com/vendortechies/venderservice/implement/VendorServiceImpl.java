package com.vendortechies.venderservice.implement;

import com.vendortechies.venderservice.dto.CustomerDto;
import com.vendortechies.venderservice.dto.ResponseDto;
import com.vendortechies.venderservice.dto.VendorDto;
import com.vendortechies.venderservice.model.Vendor;
import com.vendortechies.venderservice.repository.VendorRepository;
import com.vendortechies.venderservice.service.VendorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class VendorServiceImpl implements VendorService {
    private VendorRepository vendorRepository;
    private RestTemplate restTemplate;

    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
    public Vendor saveUser(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public ResponseDto getVendor(int vendorId) {

        ResponseDto responseDto = new ResponseDto();
        Vendor vendor = vendorRepository.findById(vendorId).get();
        VendorDto vendorDto = mapToVendor(vendor);

        ResponseEntity<CustomerDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8012/api/customers/" + vendor.getCustomerId(),
                        CustomerDto.class);

        CustomerDto customerDto = responseEntity.getBody();

        System.out.println(responseEntity.getStatusCode());

        responseDto.setVendor(vendorDto);
        responseDto.setCustomer(customerDto);

        return responseDto;
    }

    private VendorDto mapToVendor(Vendor vendor){
        VendorDto vendorDto = new VendorDto();
        vendorDto.setId(vendor.getId());
        vendorDto.setName(vendor.getName());
        vendorDto.setEmail(vendor.getEmail());
        vendorDto.setPhone(vendor.getPhone());
        vendorDto.setLocation(vendor.getLocation());

        return vendorDto;
    }

}

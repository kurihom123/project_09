package com.vendortechies.venderservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VendorDto {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String location;
    private int customerId;
}

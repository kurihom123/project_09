package com.vendortechies.venderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_vendor")
@Setter
@Getter
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor id")
    private int id;
    @Column(name = "vendor name")
    private String name;
    @Column(name = "vendor email")
    private String email;
    @Column(name = "vendor phone")
    private String phone;
    @Column(name = "vendor location")
    private String location;
    @Column(name = "customer id")
    private String customerId;

}

package com.matixtech.productinventoryservice.controller;

import com.matixtech.productinventoryservice.dto.InventoryResponse;
import com.matixtech.productinventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
//    http://localhost:8082/api/inventory/iphone_13,iphone-13_red
//    http://localhost:8082/api/inventory?skuCode=iphone_13&skuCode=iphone-13_red
    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }

}

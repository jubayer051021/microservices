package com.bjit.inventoryapp.controller;

import com.bjit.inventoryapp.config.FeignBookConfig;
import com.bjit.inventoryapp.config.FeignOrderConfig;
import com.bjit.inventoryapp.config.FeignPaymentConfig;
import com.bjit.inventoryapp.config.FeignUserConfig;
import com.bjit.inventoryapp.dto.BookResponseModel;
import com.bjit.inventoryapp.dto.ItemListDto;
import com.bjit.inventoryapp.dto.OrderDto;
import com.bjit.inventoryapp.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/valid/{orderId}")
    public String orderDelivered(@PathVariable Integer orderId){
        return inventoryService.orderDelivered(orderId);
    }

}

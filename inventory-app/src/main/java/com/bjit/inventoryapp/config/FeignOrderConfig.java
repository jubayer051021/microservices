package com.bjit.inventoryapp.config;

import com.bjit.inventoryapp.dto.ItemListDto;
//import org.springframework.cloud.openfeign.FeignClient;
import com.bjit.inventoryapp.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name= "order-app" ,url = "http://localhost:9090/order-app")
public interface FeignOrderConfig {
    @GetMapping("/order/orderDetails/{orderId}")
    public OrderDto orderDetails(@PathVariable("orderId") Integer orderId);
}

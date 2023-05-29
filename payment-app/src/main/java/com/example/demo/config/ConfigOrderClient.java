package com.example.demo.config;

import com.example.demo.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name= "order-app" ,url = "http://localhost:9090/order-app")
public interface ConfigOrderClient {
    @GetMapping("/order/orderDetails/{orderId}")
    public OrderDto orderDetails(@PathVariable("orderId") Integer orderId) ;
}

package com.bjit.inventoryapp.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="payment-app",url = "http://localhost:9090/payment-app")
public interface FeignPaymentConfig {
    @GetMapping("/payment/refund/{orderId}")
    public String refund(@PathVariable Integer orderId);
}


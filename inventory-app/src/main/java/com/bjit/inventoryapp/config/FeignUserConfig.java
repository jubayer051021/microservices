package com.bjit.inventoryapp.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
@FeignClient(name="user-app",url = "http://localhost:9090/user-app")
public interface FeignUserConfig {
    @PutMapping("/user/refund/{userId}/{amount}")
    public String refundMoney(@PathVariable("userId") Integer userId, @PathVariable("amount") Integer amount);
}

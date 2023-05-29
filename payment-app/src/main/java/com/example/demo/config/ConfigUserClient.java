package com.example.demo.config;

import com.example.demo.dto.UserResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name="user-app",url = "http://localhost:9090/user-app")
public interface ConfigUserClient {
    @GetMapping("/user/userDetails/{userId}")
    public UserResponseDto getUserDetails(@PathVariable("userId") Integer userId);
    @PutMapping("/user/withdraw/{userId}/{amount}")
    public String withdrawMoney(@PathVariable("userId") Integer userId,@PathVariable("amount") Integer amount);
}

package com.bjit.userapp.controller;

import com.bjit.userapp.dto.UserRequestDto;
import com.bjit.userapp.dto.UserResponseDto;
import com.bjit.userapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public UserResponseDto addUser(@RequestBody UserRequestDto userDto) {
        return userService.addUser(userDto);
    }
    @GetMapping("/allUser")
    public List<UserResponseDto> getAllUser() {
        return userService.getAllUser();
    }
    @GetMapping("/userDetails/{userId}")
    public UserResponseDto getUserDetails(@PathVariable("userId") Integer userId) {
        return userService.getUserDetails(userId);
    }
    @PutMapping("/withdraw/{userId}/{amount}")
    public String withdrawMoney(@PathVariable("userId") Integer userId,@PathVariable("amount") Integer amount) {
       return userService.withdrawMoney(userId,amount);
    }

    @PutMapping("/refund/{userId}/{amount}")
    public String refundMoney(@PathVariable("userId") Integer userId,@PathVariable("amount") Integer amount) {
        return userService.refundMoney(userId,amount);
    }
}

package com.example.demo.controller;

import com.example.demo.config.ConfigOrderClient;
import com.example.demo.config.ConfigUserClient;
import com.example.demo.entity.PaymentEntity;
import com.example.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final ConfigOrderClient configOrderClient;
    private final ConfigUserClient configUserClient;

    @GetMapping("/pay/{orderId}")
    public String payment(@PathVariable Integer orderId) {
        return paymentService.payment(orderId);
    }

    @GetMapping ("/refund/{orderId}")
    public String refund(@PathVariable Integer orderId) {
        return paymentService.refund(orderId);
    }

    @GetMapping("/allPaymentList")
    public List<PaymentEntity> allPaymentList(){
        return paymentService.allPaymentList();
    }
}

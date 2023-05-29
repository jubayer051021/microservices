package com.example.demo.service;

import com.example.demo.config.ConfigOrderClient;
import com.example.demo.config.ConfigUserClient;
import com.example.demo.dto.OrderDto;
import com.example.demo.dto.PaymentDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.PaymentEntity;
import com.example.demo.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final ConfigOrderClient configOrderClient;
    private final ConfigUserClient configUserClient;
    public String payment(Integer orderId) {
        OrderDto orderDetails = configOrderClient.orderDetails(orderId);
        Integer userId=orderDetails.getUserID();
        UserResponseDto user=configUserClient.getUserDetails(userId);
        if(user.getAccountBalance()<orderDetails.getTotalPrice()){
            return "Insufficient Balance";
        }
        configUserClient.withdrawMoney(user.getUserId(), orderDetails.getTotalPrice());
        PaymentEntity paymentEntity=new PaymentEntity();
        paymentEntity.setOrderId(orderId);
        paymentEntity.setPaymentAmount(orderDetails.getTotalPrice());
        paymentEntity.setPaymentStatus("payment");
        paymentRepository.save(paymentEntity);
        return "SuccessFully payment";
    }

    public String refund(Integer orderId) {
       PaymentEntity paymentEntity= paymentRepository.findByOrderId(orderId);
       paymentRepository.delete(paymentEntity);
        return "Refund the money and payment details Cancelled";
    }

    public List<PaymentEntity> allPaymentList() {
       return paymentRepository.findAll();
    }
}

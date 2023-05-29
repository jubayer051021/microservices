package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentId;
    private Integer orderId;
    private String paymentStatus;
    private Integer paymentAmount;
}

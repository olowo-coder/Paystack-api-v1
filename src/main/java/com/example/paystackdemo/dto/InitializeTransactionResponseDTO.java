package com.example.paystackdemo.dto;


import lombok.Data;

@Data
public class InitializeTransactionResponseDTO {
    private String status;
    private String message;
    private PaymentData data;
}

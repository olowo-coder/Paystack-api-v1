package com.example.paystackdemo.dto.response;

import lombok.Data;

@Data
public class TransVerificationResponse {
    private TransVerifyData data;
    private boolean status;
    private String message;
}

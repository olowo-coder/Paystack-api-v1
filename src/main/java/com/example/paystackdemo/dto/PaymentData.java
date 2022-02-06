package com.example.paystackdemo.dto;

import lombok.Data;

@Data
public class PaymentData {
    private String authorization_url;
    private String access_code;
    private String reference;
}

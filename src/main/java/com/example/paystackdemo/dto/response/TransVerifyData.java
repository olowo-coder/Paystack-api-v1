package com.example.paystackdemo.dto.response;

import lombok.Data;

@Data
public class TransVerifyData {
    private int id;
    private String domain;
    private String status;
    private String reference;
    private int amount;
    private String message;
    private String gateway_response;
    private String paid_at;
    private String currency;
    private String channel;
    private String created_at;
    private String transaction_date;
    private int requested_amount;
    private Customer customer;
    private Authorization authorization;
    private int fees;
    private Log log;
    private String metadata;
    private String ip_address;
    private String plan;
    private String request_amount;

}

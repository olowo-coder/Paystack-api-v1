package com.example.paystackdemo.dto.response;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String risk_action;
    private String customer_code;
}

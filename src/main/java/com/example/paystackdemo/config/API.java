package com.example.paystackdemo.config;

import lombok.Data;

@Data
public class API {

    public static String API_KEY_PAYMENT = System.getenv("API_KEY_PAYMENT");
}

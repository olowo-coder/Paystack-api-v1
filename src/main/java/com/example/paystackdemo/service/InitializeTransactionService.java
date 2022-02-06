package com.example.paystackdemo.service;

import com.example.paystackdemo.dto.InitializeTransactionRequestDTO;
import com.example.paystackdemo.dto.InitializeTransactionResponseDTO;
import com.example.paystackdemo.dto.response.TransVerificationResponse;

public interface InitializeTransactionService {
    InitializeTransactionResponseDTO initializeTransaction(InitializeTransactionRequestDTO initializeTransactionRequestDTO);

    TransVerificationResponse confirmation(String reference);
}

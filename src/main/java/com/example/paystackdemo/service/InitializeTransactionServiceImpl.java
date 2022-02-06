package com.example.paystackdemo.service;

import com.example.paystackdemo.config.API;
import com.example.paystackdemo.dto.InitializeTransactionRequestDTO;
import com.example.paystackdemo.dto.InitializeTransactionResponseDTO;
import com.example.paystackdemo.dto.response.PaymentResponse;
import com.example.paystackdemo.dto.response.TransVerificationResponse;
import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@AllArgsConstructor
public class InitializeTransactionServiceImpl implements InitializeTransactionService{
    private final RestTemplate restTemplate;

    @Override
    public InitializeTransactionResponseDTO initializeTransaction(
            InitializeTransactionRequestDTO initializeTransactionRequestDTO){
        String referenceGenerator = "fitnesso-app-" + RandomString.make(16);
        initializeTransactionRequestDTO.setReference(referenceGenerator);
        final String url = "https://api.paystack.co/transaction/initialize";
        HttpHeaders headers = new HttpHeaders();
        String key = API.API_KEY_PAYMENT;
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + key);
        HttpEntity<InitializeTransactionRequestDTO> entity =
                new HttpEntity<>(initializeTransactionRequestDTO,headers);
        ResponseEntity<InitializeTransactionResponseDTO> response =
                restTemplate.postForEntity(url, entity,InitializeTransactionResponseDTO.class);
        return response.getBody();
    }

    @Override
    public TransVerificationResponse confirmation(String reference) {
        final String url = "https://api.paystack.co/transaction/verify/" + reference;
        HttpHeaders headers = new HttpHeaders();
        String key = API.API_KEY_PAYMENT;
        headers.set("Authorization", "Bearer " + key);
        HttpEntity<TransVerificationResponse> entity = new HttpEntity<>(headers);
        ResponseEntity<TransVerificationResponse> response = restTemplate.exchange(url, HttpMethod.GET,entity,TransVerificationResponse.class);
        return response.getBody();
    }

    public PaymentResponse printStatus(TransVerificationResponse transaction){
        if(transaction.getData().getMessage().equals("success")){
            return PaymentResponse.builder().message("Payment was Successful").status("OK").build();
        }
        return PaymentResponse.builder().message("Transaction Failed").build();
    }

}

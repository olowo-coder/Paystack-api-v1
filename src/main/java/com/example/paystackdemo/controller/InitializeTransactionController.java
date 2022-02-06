package com.example.paystackdemo.controller;

import com.example.paystackdemo.dto.InitializeTransactionRequestDTO;
import com.example.paystackdemo.dto.InitializeTransactionResponseDTO;
import com.example.paystackdemo.dto.response.TransVerificationResponse;
import com.example.paystackdemo.service.InitializeTransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class InitializeTransactionController {

    private final InitializeTransactionService initializeTransactionService;

    @PostMapping("/payment")
    public ResponseEntity<InitializeTransactionResponseDTO> initializeTransaction(
            @RequestBody InitializeTransactionRequestDTO initializeTransactionRequestDTO){
        return ResponseEntity.ok(initializeTransactionService.initializeTransaction(initializeTransactionRequestDTO));
    }

    @GetMapping("/confirm-payment/{reference}")
    public ResponseEntity<TransVerificationResponse> confirmPayment(@PathVariable("reference") String reference){
        return ResponseEntity.ok(initializeTransactionService.confirmation(reference));
    }
}

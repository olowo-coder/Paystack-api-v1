package com.example.paystackdemo.dto;

import com.example.paystackdemo.model.Channels;
import com.example.paystackdemo.model.PayStackBearer;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class InitializeTransactionRequestDTO {

    private String amount;
    private String email;
    private String reference;
//    private String callback_url;
//    private Integer invoice_limit;
    private List<Channels> channels = Arrays.asList(Channels.CARD);
//    private String subaccount;
    private Integer transaction_charge = 10;
//    private PayStackBearer payStackBearer = PayStackBearer.ACCOUNT;
}

package com.example.paystackdemo.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class Log {
    private List<History> history;
    private List<String> input;
    private boolean mobile;
    private boolean success;
    private int errors;
    private int attempts;
    private int time_spent;
    private int start_time;
}

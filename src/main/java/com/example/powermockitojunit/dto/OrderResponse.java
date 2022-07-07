package com.example.powermockitojunit.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class OrderResponse {
    private OrderRequest response;
    private String message;
    private int statusCode;

}

package com.example.powermockitojunit.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {


    private int id;
    private  String name;
    private int quantity;
    private int price;
    private String emailId;
    private boolean isDiscountable;
}

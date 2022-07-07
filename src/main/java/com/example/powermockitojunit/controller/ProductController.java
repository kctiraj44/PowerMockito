package com.example.powermockitojunit.controller;

import com.example.powermockitojunit.dto.OrderRequest;
import com.example.powermockitojunit.dto.OrderResponse;
import com.example.powermockitojunit.servive.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
private ProductService service;


    private OrderResponse placeOrder(@RequestBody OrderRequest orderRequest){
        return service.checkOutOrder(orderRequest);
    }
}

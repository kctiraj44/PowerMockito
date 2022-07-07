package com.example.powermockitojunit.servive;

import com.example.powermockitojunit.Util.NotificationUtil;
import com.example.powermockitojunit.dto.OrderRequest;
import com.example.powermockitojunit.dto.OrderResponse;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public OrderResponse checkOutOrder(OrderRequest order){
        //call DAO
        int discount = addDiscount(order);
        order.setPrice(order.getPrice()-discount);
       String message =   NotificationUtil.sendEmail(order.getEmailId());
        return  new OrderResponse(order,message, HttpStatus.OK.value());
    }


    private int addDiscount(OrderRequest order) {
        System.out.println("*-------------------------------*");
        System.out.println("called...");
        int price = order.getPrice();
        int discountAMount = 0;
        if (order.isDiscountable()) {
            if (order.getPrice() > 1000) {
                discountAMount = price * 10 / 100;
            } else {
                discountAMount = price;
            }
        } else {
            discountAMount = price;
        }
        return discountAMount;
    }

}

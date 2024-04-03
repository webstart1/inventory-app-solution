package com.piquota.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StockServiceClient {
    @Autowired
    private RestTemplate template;

//    public OrderResponseDTO fetchOrderStatus(String orderId) {
//        return template.getForObject("http://RESTAURANT-SERVICE/restaurant/orders/status/" + orderId, OrderResponseDTO.class);
//    }


    public String callCancelOrder(String orderId) {
        return template.getForObject("http://STOCK-SERVICE/stock/cancelorder/" + orderId, String.class);
    }
}

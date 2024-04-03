package com.piquota.controller;

import com.piquota.dto.StockOrderDTO;
import com.piquota.exceptionhandling.AppException;
import com.piquota.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/stock")
public class AppController {


    @Autowired
    private StockService service;

    @PostMapping("/placeorder")
    public StockOrderDTO placeOrder(@RequestBody StockOrderDTO dto) throws AppException {

        if(Objects.nonNull(dto)){
            return this.service.placeOrder(dto);
        }

        return null;
    }

    @GetMapping("/cancelorder/{orderId}")
    public String cancelOrder(@PathVariable String orderId) throws AppException{

        if(!ObjectUtils.isEmpty(orderId)){
            return this.service.cancelOrder(Integer.parseInt(orderId));
        }

        return "";

    }
}

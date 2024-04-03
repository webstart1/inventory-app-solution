package com.piquota.service;


import com.piquota.dto.StockOrderDTO;
import com.piquota.exceptionhandling.AppException;


public interface StockService {

    StockOrderDTO placeOrder(StockOrderDTO dto) throws AppException;
    String cancelOrder(Integer orderId) throws AppException;
}

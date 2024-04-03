package com.piquota.service;

import com.piquota.dto.StockOrderDTO;
import com.piquota.entity.StockOrder;
import com.piquota.exceptionhandling.AppException;
import com.piquota.repository.StockRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements  StockService{


    @Autowired
    private StockRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public StockOrderDTO placeOrder(StockOrderDTO dto) throws AppException {
        try {
            StockOrder stockOrder = mapper.map(dto, StockOrder.class);
            System.out.println("placing order");
            System.out.println(stockOrder);
            StockOrder res = this.repo.save(stockOrder);
            return mapper.map(res, StockOrderDTO.class);
        }
        catch (Exception ex){
            throw new AppException(101, ex.getMessage());
        }

    }

    @Override
    public String cancelOrder(Integer orderId) throws AppException {
        this.repo.deleteById(orderId);
        return "Order Cancelled!";
    }
}

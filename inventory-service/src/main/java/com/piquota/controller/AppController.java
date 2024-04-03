package com.piquota.controller;

import com.netflix.discovery.converters.Auto;
import com.piquota.client.StockServiceClient;
import com.piquota.dto.InventoryDTO;
import com.piquota.dto.OrderDTO;
import com.piquota.exceptionhandling.AppException;
import com.piquota.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/inventory")
public class AppController {


    @Autowired
    private InventoryService service;


    @Autowired
    private StockServiceClient client;

    @GetMapping("/{inventoryId}")
    public InventoryDTO getInventoryItem(@PathVariable String inventoryId) throws AppException {
        return this.service.getInventoryItem(Integer.parseInt(inventoryId));

    }

    @PostMapping("/addInventory")
    public String addInventory(@RequestBody InventoryDTO dto) throws AppException {
        return this.service.addInventory(dto);
    }


    @DeleteMapping("/remove/{inventoryId}")
    public String removeInventory(@PathVariable String inventoryId) throws AppException {
        return this.service.removeInventory(Integer.parseInt(inventoryId));
    }

    @PostMapping("/placeorder")
    public OrderDTO placeOrder(@RequestBody OrderDTO dto) {

        if(Objects.nonNull(dto)){
            //add rest template call

        }

        return null;
    }

    @PostMapping("/cancelorder/{orderId}")
    public String cancelOrder(@PathVariable String orderId) {

        if(!ObjectUtils.isEmpty(orderId)){
         return this.client.callCancelOrder(orderId);
        }

        return null;

    }


}

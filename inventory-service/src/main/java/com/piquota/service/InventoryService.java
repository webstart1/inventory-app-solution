package com.piquota.service;

import com.piquota.dto.InventoryDTO;
import com.piquota.exceptionhandling.AppException;
import org.springframework.stereotype.Service;


public interface InventoryService {


    InventoryDTO getInventoryItem(Integer inventoryId) throws AppException;

    String addInventory(InventoryDTO dto) throws  AppException;

    String removeInventory(Integer inventoryId) throws  AppException;

}

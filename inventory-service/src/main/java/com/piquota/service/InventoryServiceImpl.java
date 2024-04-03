package com.piquota.service;

import com.piquota.dto.InventoryDTO;
import com.piquota.entity.Inventory;
import com.piquota.exceptionhandling.AppException;
import com.piquota.repo.InventoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements  InventoryService{

    @Autowired
    private InventoryRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public InventoryDTO getInventoryItem(Integer inventoryId) throws AppException {
        try {
            Inventory entity = this.repo.findById(inventoryId).get();
            return mapper.map(entity, InventoryDTO.class);
        }
        catch (Exception ex){
            throw new AppException(201, ex.getMessage());
        }
    }

    @Override
    public String addInventory(InventoryDTO dto) throws AppException {
        try {
            Inventory entity= mapper.map(dto, Inventory.class);
            this.repo.save(entity);
            return "Inventory item added";
        }
        catch (Exception ex){
            throw new AppException(202, ex.getMessage());
        }
    }

    @Override
    public String removeInventory(Integer inventoryId) throws AppException {
        try {
            this.repo.deleteById(inventoryId);
            return "Inventory item deleted";
        }
        catch (Exception ex){
            throw new AppException(203, ex.getMessage());
        }
    }
}

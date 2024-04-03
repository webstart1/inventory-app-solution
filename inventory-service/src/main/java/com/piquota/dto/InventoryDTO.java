package com.piquota.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO {

    private Integer id;
    private String name;
    private String description;
    private Integer quantity;
    private Integer stockItemId;
    private String stockStatus;
}

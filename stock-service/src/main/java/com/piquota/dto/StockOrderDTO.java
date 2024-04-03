package com.piquota.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockOrderDTO {

    private Integer id;
    private String description;
    private String status;
    private Integer stockItemId;
}

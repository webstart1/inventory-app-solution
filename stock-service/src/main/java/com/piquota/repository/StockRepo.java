package com.piquota.repository;

import com.piquota.entity.StockOrder;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StockRepo extends JpaRepository<StockOrder,Integer> {

}